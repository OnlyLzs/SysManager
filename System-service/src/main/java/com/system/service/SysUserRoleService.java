package com.system.service;

import java.util.List;

/**
 * 用户 角色 service
 * @class SysUserRoleService
 * @author Jason
 * @description
 * @date Jan 28, 2019 5:15:08 PM
 */
public interface SysUserRoleService {

	/**
	 * @Description 保存或更新用户角色
	 * @author Jason
	 * @date Jan 28, 2019
	 * @param userId
	 * @param roleIds
	 */
	void saveOrUpdate(Integer userId, String roleIds);

	/** 
	 * @Description 根据ids 删除用户角色
	 * @author Jason
	 * @date Jan 29, 2019
	 * @param ids
	 */
	void deleteRoleByUserIds(List<Integer> ids);

}
