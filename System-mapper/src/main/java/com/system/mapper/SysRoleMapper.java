package com.system.mapper;

import java.util.List;

import com.system.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	List<SysRole> queryAll();

	List<SysRole> queryByUserId(Integer userId);
}