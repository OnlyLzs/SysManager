package com.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.system.entity.SysUser;
import com.system.mapper.SysUserMapper;
import com.system.response.ResponseStatusMsg;
import com.system.response.StatusResult;
import com.system.service.SysUserService;

/**
 * 用户接口实现类
 * @class SysUserServiceImpl
 * @author Jason
 * @description
 * @date Jan 8, 2019 5:23:23 PM
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	
	@Override
	public SysUser queryByUserName(String username) {
		
		return sysUserMapper.queryByUserName(username);
	}

	@Override
	public StatusResult queryUserByCondition() {
		List<SysUser> sysUsers = sysUserMapper.queryUserByCondition();
		if(!ObjectUtils.isEmpty(sysUsers)) {
			return StatusResult.ok(ResponseStatusMsg.FIND_SUCCESS.getMsg(), sysUsers);
		}
		return StatusResult.ok(ResponseStatusMsg.FIND_NONE.getMsg());
	}

}
