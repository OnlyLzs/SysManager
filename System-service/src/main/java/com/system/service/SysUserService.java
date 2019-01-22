package com.system.service;

import java.util.List;

import com.system.entity.SysResource;
import com.system.entity.SysUser;
import com.system.response.StatusResult;

/**
 * 用户管理接口
 * @class SysUserService
 * @author Jason
 * @description
 * @date Jan 8, 2019 5:22:24 PM
 */
public interface SysUserService {

	/**
	 * @Description 根据用户名查找用户信息
	 * @author Jason
	 * @date Jan 9, 2019
	 * @param username
	 * @return
	 */
	SysUser queryByUserName(String username);

	/**
	 * @Description 查询系统用户信息
	 * @author Jason
	 * @param condition 
	 * @param sysUser 
	 * @param pageSize 
	 * @param pageNum 
	 * @date Jan 17, 2019
	 * @return
	 */
	StatusResult queryUserByCondition(Integer pageNum, Integer pageSize, SysUser sysUser, String condition);

}
