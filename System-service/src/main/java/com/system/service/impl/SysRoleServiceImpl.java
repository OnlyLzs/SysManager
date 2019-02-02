package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.SysRole;
import com.system.mapper.SysRoleMapper;
import com.system.response.ResponseStatusMsg;
import com.system.response.StatusResult;
import com.system.service.SysResourceService;
import com.system.service.SysRoleResourceService;
import com.system.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	SysRoleMapper sysRoleMapper;

	@Autowired
	SysRoleResourceService sysRoleResourceService;
	
	@Override
	public List<SysRole> queryAll() {
		return sysRoleMapper.queryAll();
	}

	@Override
	public List<SysRole> queryByUserId(Integer userId) {
		
		return sysRoleMapper.queryByUserId(userId);
	}

	@Override
	public StatusResult queryRoleByCondition(Integer pageNum, Integer pageSize, String condition) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysRole> roleList = sysRoleMapper.queryByCondition(condition);
		PageInfo<SysRole> pageInfo = new PageInfo<>(roleList);
		if(!ObjectUtils.isEmpty(pageInfo)) {
			return StatusResult.ok(ResponseStatusMsg.FIND_SUCCESS.getMsg(), pageInfo);
		}
		return StatusResult.ok(ResponseStatusMsg.FIND_NONE.getMsg());
	}

	@Override
	@Transactional
	public StatusResult saveRole(SysRole sysRole) {
		
		int result = sysRoleMapper.insertSelective(sysRole);
		sysRoleResourceService.saveOrUpdate(sysRole.getRoleId(), sysRole.getResourceIds());
		if (result>0) {
			return StatusResult.ok(ResponseStatusMsg.ADD_SUCCESS.getMsg());
		}
		return StatusResult.error(ResponseStatusMsg.ADD_SUCCESS.getMsg());
	}

	@Override
	public SysRole queryByRoleId(Integer roleId) {
		
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

}
