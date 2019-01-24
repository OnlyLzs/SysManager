package com.system.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.SysUser;
import com.system.response.StatusResult;
import com.system.service.SysUserService;

/**
 * @class SysUserController
 * @author Jason
 * @description
 * @date Jan 11, 2019 4:08:58 PM
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/list")
	public ModelAndView queryUserHTML() {
		logger.info("后台 用户管理界面跳转");
		ModelAndView model = new ModelAndView("/user/list");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/queryUserByCondition")
	public StatusResult queryUserByCondition(
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,
			SysUser sysUser, String condition) {
		logger.info("后台 查询所有用户");
		return sysUserService.queryUserByCondition(pageNum, pageSize, sysUser, condition);
	}
	
}
