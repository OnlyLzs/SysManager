package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.system.entity.SysResource;

@Mapper
public interface SysResourceMapper {
	
    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

	List<SysResource> queryByUserId(Integer userId);

	List<SysResource> queryMenuByUserId(Integer userId);

	/**
	 * @Description 查询所有权限  递归 树形
	 * @author Jason
	 * @date Jan 30, 2019
	 * @param parentId
	 * @return
	 */
	List<SysResource> queryAllTree(Integer parentId);

	
	/**
	 * @Description 查询所有权限
	 * @author Jason
	 * @date Jan 31, 2019
	 * @return
	 */
	List<SysResource> queryAll();
}