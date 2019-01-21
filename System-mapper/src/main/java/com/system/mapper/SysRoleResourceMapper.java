package com.system.mapper;

import com.system.entity.SysRoleResource;

public interface SysRoleResourceMapper {
    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);
}