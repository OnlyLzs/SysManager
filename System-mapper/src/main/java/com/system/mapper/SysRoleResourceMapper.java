package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.entity.SysRoleResource;

public interface SysRoleResourceMapper {
    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    /**
     * @Description 根据角色Id删除对应权限
     * @author Jason
     * @date Jan 31, 2019
     * @param roleId
     * @return
     */
	int deleteByRoleId(Integer roleId);
	
	/**
	 * @Description 保存角色的 权限
	 * @author Jason
	 * @date Jan 31, 2019
	 * @param roleId
	 * @param resourceIds
	 */
	void save(@Param(value="roleId")Integer roleId, @Param(value="resourceIdArray")List<Integer> resourceIds);
}