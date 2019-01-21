package com.system.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.system.entity.SysUser;
import com.system.utils.ShiroUtils;

/**
 * 获取登录者公共组件
 * @class UserCommon
 * @author Jason
 * @description
 * @date Jan 10, 2019 6:10:00 PM
 */
public abstract class UserCommon {
protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUser getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Integer getUserId() {
		return getUser().getUserId();
	}
}
