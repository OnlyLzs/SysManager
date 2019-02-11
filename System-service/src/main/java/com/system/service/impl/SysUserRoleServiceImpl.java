package com.system.service.impl;

import java.util.List;

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
		if(roleIds!=null && !roleIds.trim().equals("")) {
			String[] roleIdArray = roleIds.split(",");
			sysUserRoleMapper.save(userId, roleIdArray);
		}
	}

	@Override
	public void deleteByUserIds(List<Integer> ids) {
		sysUserRoleMapper.deleteByUserIds(ids);
	}

	@Override
	public void deleteByRoleIds(List<Integer> ids) {
		sysUserRoleMapper.deleteByRoleIds(ids);
		
	}

	

}
