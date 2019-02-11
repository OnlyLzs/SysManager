package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.SysUser;
import com.system.mapper.SysUserMapper;
import com.system.response.ResponseStatusMsg;
import com.system.response.StatusResult;
import com.system.service.SysUserRoleService;
import com.system.service.SysUserService;
import com.system.utils.PasswordUtils;

/**
 * 用户接口实现类
 * @class SysUserServiceImpl
 * @author Jason
 * @description
 * @date Jan 8, 2019 5:23:23 PM
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	SysUserRoleService sysUserRoleService;
	
	@Override
	public SysUser queryByUserName(String username) {
		
		return sysUserMapper.queryByUserName(username);
	}

	@Override
	public StatusResult queryUserByCondition(Integer pageNum, Integer pageSize, SysUser sysUser, String condition) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysUser> sysUsers = sysUserMapper.queryUserByCondition(sysUser, condition);
		PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
		if(!ObjectUtils.isEmpty(pageInfo)) {
			return StatusResult.ok(ResponseStatusMsg.FIND_SUCCESS.getMsg(), pageInfo);
		}
		return StatusResult.ok(ResponseStatusMsg.FIND_NONE.getMsg());
	}

	@Override
	public SysUser queryById(Integer id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		return sysUser;
	}

	@Override
	@Transactional
	public StatusResult updateUser(String str) {
		JSONObject jsonObject = JSONObject.parseObject(str);
		SysUser sysUser = JSON.toJavaObject(jsonObject, SysUser.class);
		String roleIds = jsonObject.getString("roleIds");
		int result = sysUserMapper.updateByPrimaryKeySelective(sysUser);
		sysUserRoleService.saveOrUpdate(sysUser.getUserId(), roleIds);
		if(result>0) {
			return StatusResult.ok(ResponseStatusMsg.UPDATE_SUCCESS.getMsg());
		}
		return StatusResult.error(ResponseStatusMsg.UPDATE_FAIL.getMsg()) ;
	}

	@Override
	@Transactional
	public StatusResult deleteUser(List<Integer> ids) {
		//s 先删除中间表的数据 再删除用户(可能没有角色) 
		sysUserRoleService.deleteByUserIds(ids);
		//s删除用户
		int result = sysUserMapper.deleteUserByIds(ids);
		if (result>0) {
			return StatusResult.ok(ResponseStatusMsg.DELETE_SUCCESS.getMsg());
		}
		return StatusResult.error(ResponseStatusMsg.DELETE_FAIL.getMsg());
	}

	@Override
	@Transactional
	public StatusResult saveUser(String userInfo) {
		JSONObject jsonObject = JSONObject.parseObject(userInfo);
		SysUser sysUser = JSON.toJavaObject(jsonObject, SysUser.class);
		sysUser.setPassword(PasswordUtils.encodPassword(sysUser.getPassword()));
		int userResult = sysUserMapper.insertSelective(sysUser);
		String roleIds = jsonObject.getString("roleIds");
		sysUserRoleService.saveOrUpdate(sysUser.getUserId(), roleIds);
		if(userResult>0) {
			return StatusResult.ok(ResponseStatusMsg.ADD_SUCCESS.getMsg());
		}
		return StatusResult.error(ResponseStatusMsg.ADD_FAIL.getMsg());
	}

}
