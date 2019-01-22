package com.system.config.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.system.entity.SysResource;
import com.system.entity.SysUser;
import com.system.service.SysResourceService;
import com.system.service.SysUserService;
import com.system.utils.PasswordUtils;

/**
 * 自定义系统shiroRealm
 * 
 * @class SysShiroRealm
 * @author Jason
 * @description
 * @date Jan 8, 2019 5:19:05 PM
 */
public class SysShiroRealm extends AuthorizingRealm {

	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	SysResourceService sysResourceService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	// s后授权认证
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		logger.info("授权认证开始了");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		// s这个地方从数据中查询用户，并且关联查询出用户对应的角色以及权限 ，实现权限的认证
		List<SysResource> resources = sysResourceService.queryByUserId(user.getUserId());
		for(SysResource sysResource:resources) {
			if(sysResource.getPermission()!=null) {
				authorizationInfo.addStringPermission(sysResource.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	// s先登录认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		logger.info("登录认证开始了");
		String username = (String)token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		SysUser user = sysUserService.queryByUserName(username);
		 //s账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        //s密码错误
        if(!PasswordUtils.encodPassword(password).equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        //s账号锁定
        if(user.getStatus() == 0){
        	throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        /**
		 * 参数详解
		 * 第一个参数principal ：认证的实体信息。可以是username,也可以是用户的实体类对象
		 * 第二个参数hashedCredentials：是从数据库中获取的密码
		 * 第三个参数credentialsSalt：盐值，它的作用就是，即是两个人的原明文密码一样，可以通过这个值的控制，使加密后的密码不一样(一般可以使用username或者userid作为盐值)
		 * 第四个参数realmName: 当前 Realm 对象的 name调用父类的getName()方法即可
		 *  注意 如果第二个参数误填为password 也就是登录时填写的密码 那么去掉上面的自己写的验证密码 身份验证总会成功
		 */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), null, getName());
        return info;
	}

}
