package com.system.service;

import java.util.List;

public interface SysRoleResourceService {

	/**
	 * @Description 更新或保存权限
	 * @author Jason
	 * @date Jan 31, 2019
	 * @param roleId
	 * @param list
	 */
	void saveOrUpdate(Integer roleId, List<Integer> list);

	/**
	 * @Description 根据角色删除 权限
	 * @author Jason
	 * @date Feb 11, 2019
	 * @param ids
	 */
	void deleteByRoleIds(List<Integer> ids);

}
