package com.system.service;

import java.util.List;

import com.system.entity.SysRole;

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

	

}
