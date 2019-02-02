package com.system.service;

import java.util.List;

import com.system.entity.SysRole;
import com.system.response.StatusResult;

public interface SysRoleService {

	/**
	 * @Description查询所有角色
	 * @author Jason
	 * @date Jan 25, 2019
	 * @return
	 */
	List<SysRole> queryAll();

	/**
	 * @Description 根据用户Id查询所有角色
	 * @author Jason
	 * @date Jan 25, 2019
	 * @param userId
	 * @return
	 */
	List<SysRole> queryByUserId(Integer userId);

	/**
	 * @Description 根据条件查询角色 分页
	 * @author Jason
	 * @date Jan 30, 2019
	 * @param pageNum
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	StatusResult queryRoleByCondition(Integer pageNum, Integer pageSize, String condition);

	/**
	 * @Description 添加角色信息
	 * @author Jason
	 * @date Jan 31, 2019
	 * @param sysRole
	 * @return
	 */
	StatusResult saveRole(SysRole sysRole);

	/** 
	 * @Description 根据 id 查询角色信息
	 * @author Jason
	 * @date Feb 2, 2019
	 * @param roleId
	 * @return
	 */
	SysRole queryByRoleId(Integer roleId);

	

}
