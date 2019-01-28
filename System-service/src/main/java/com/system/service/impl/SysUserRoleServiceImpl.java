package com.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.mapper.SysUserRoleMapper;
import com.system.service.SysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;

	@Override
	public void saveOrUpdate(Integer userId, String roleIds) {
		sysUserRoleMapper.deleteByUserId(userId);
		if(roleIds!=null && roleIds.trim()!="") {
			String[] roleIdArray = roleIds.split(",");
			sysUserRoleMapper.save(userId, roleIdArray);
		}
	}

	

}
