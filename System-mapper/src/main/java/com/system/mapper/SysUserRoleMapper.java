package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.system.entity.SysUserRole;

@Mapper
public interface SysUserRoleMapper {
	
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    /**
     * @Description 根据用户Id删除用户角色
     * @author Jason
     * @date Jan 28, 2019
     * @param userId
     */
	void deleteByUserId(Integer userId);

	/**
	 * @Description 根据用户id 赋予角色
	 * @author Jason
	 * @date Jan 28, 2019
	 * @param userId
	 * @param roleIdArray
	 */
	void save(@Param(value = "userId") Integer userId, @Param(value="roleIdArray")String[] roleIdArray);

	/**
	 * @Description 根据用户Ids 删除用户角色
	 * @author Jason
	 * @date Jan 29, 2019
	 * @param ids
	 */
	void deleteRoleByUserIds(List<Integer> ids);
}