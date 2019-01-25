package com.system.controller;

import java.util.List;

import javax.security.auth.Subject;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.SysRole;
import com.system.entity.SysUser;
import com.system.response.StatusResult;
import com.system.service.SysRoleService;
import com.system.service.SysUserService;

/**
 * @class SysUserController
 * @author Jason
 * @description
 * @date Jan 11, 2019 4:08:58 PM
 */
@Controller
@RequestMapping("sys/user")
public class SysUserController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysRoleService sysRoleService;
	
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
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable("id")Integer id, ModelAndView mv) {
		logger.info("后台 跳转到编辑用户界面");
		SysUser sysUser = sysUserService.queryById(id);
		List<SysRole> sysRoles = sysRoleService.queryAll();
		List<SysRole> roles = sysRoleService.queryByUserId(id);
		sysUser.setRoles(roles);
		mv.addObject("sysUser", sysUser);
		mv.addObject("sysRoles", sysRoles);
		mv.setViewName("/user/edit");
		return mv;
	}
	
}
