package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.entity.SysRole;
import com.system.mapper.SysRoleMapper;
import com.system.response.ResponseStatusMsg;
import com.system.response.StatusResult;
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

}
