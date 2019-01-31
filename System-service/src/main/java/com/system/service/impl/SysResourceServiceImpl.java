package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.SysResource;
import com.system.mapper.SysResourceMapper;
import com.system.service.SysResourceService;

@Service
public class SysResourceServiceImpl implements SysResourceService {

	@Autowired
	SysResourceMapper sysResourceMapper;
	
	@Override
	public List<SysResource> queryByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return sysResourceMapper.queryByUserId(userId);
	}

	@Override
	public List<SysResource> queryMenuByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return sysResourceMapper.queryMenuByUserId(userId);
	}

	@Override
	public List<SysResource> queryAllTree() {
		
		return sysResourceMapper.queryAllTree(0);
	}

	@Override
	public List<SysResource> queryAll() {
		// TODO Auto-generated method stub
		return sysResourceMapper.queryAll();
	}

}
