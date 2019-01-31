package com.system.service;

import java.util.List;

import com.system.entity.SysResource;

/**
 * 权限管理接口
 * @class SysResourceService
 * @author Jason
 * @description
 * @date Jan 9, 2019 3:42:47 PM
 */
public interface SysResourceService {

	/**
	 * 根据用户id 查询用户权限
	 * @Description
	 * @author Jason
	 * @date Jan 9, 2019
	 * @param userId
	 * @return
	 */
	List<SysResource> queryByUserId(Integer userId);

	/** 
	 * @Description 根据用户id查询相应菜单
	 * @author Jason
	 * @date Jan 10, 2019
	 * @param userId
	 * @return
	 */
	List<SysResource> queryMenuByUserId(Integer userId);

	/**
	 * @Description 查询所有权限（递归  树形结构）
	 * @author Jason
	 * @date Jan 30, 2019
	 * @return
	 */
	List<SysResource> queryAllTree();

	
	/**
	 * @Description 查询所有权限
	 * @author Jason
	 * @date Jan 31, 2019
	 * @return
	 */
	List<SysResource> queryAll();

	

}
