package com.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.system.entity.SysUserRole;

@Mapper
public interface SysUserRoleMapper {
	
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    /**
     * @Description 根据用户Id删除用户权限
     * @author Jason
     * @date Jan 28, 2019
     * @param userId
     */
	void deleteByUserId(Integer userId);

	/**
	 * @Description 根据用户id 赋予权限
	 * @author Jason
	 * @date Jan 28, 2019
	 * @param userId
	 * @param roleIdArray
	 */
	void save(@Param(value = "userId") Integer userId, @Param(value="roleIdArray")String[] roleIdArray);
}