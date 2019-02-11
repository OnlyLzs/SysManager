package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.mapper.SysRoleResourceMapper;
import com.system.service.SysRoleResourceService;

@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
	
	@Autowired
	SysRoleResourceMapper sysRoleResourceMapper;

	@Override
	public void saveOrUpdate(Integer roleId,  List<Integer> resourceIds) {
		int result = sysRoleResourceMapper.deleteByRoleId(roleId);
		if(resourceIds.size()!=0) {
			sysRoleResourceMapper.save(roleId, resourceIds);
 		}
		
	}

	@Override
	public void deleteByRoleIds(List<Integer> ids) {
		sysRoleResourceMapper.deleteByRoleIds(ids);
	}

}
