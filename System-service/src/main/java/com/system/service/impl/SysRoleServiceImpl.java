package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.SysRole;
import com.system.mapper.SysRoleMapper;
import com.system.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Override
	public List<SysRole> queryAll() {
		return sysRoleMapper.queryAll();
	}

	@Override
	public List<SysRole> queryByUserId(Integer userId) {
		
		return sysRoleMapper.queryByUserId(userId);
	}

}
