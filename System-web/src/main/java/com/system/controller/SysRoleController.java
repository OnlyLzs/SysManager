package com.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.entity.SysResource;
import com.system.entity.SysRole;
import com.system.entity.SysUser;
import com.system.response.StatusResult;
import com.system.service.SysResourceService;
import com.system.service.SysRoleService;
import com.system.utils.ZtreeBean;

/**
 * 角色controller
 * @class SysRoleController
 * @author Jason
 * @description
 * @date Jan 30, 2019 10:33:18 AM
 */
@Controller
@RequestMapping("sys/role")
public class SysRoleController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SysRoleService sysRoleService;
	@Autowired
	SysResourceService sysResourceService;
	
	@RequestMapping("/list")
	public ModelAndView queryRoleHTML(ModelAndView mv) {
		logger.info("后台  查询角色页面跳转");
		mv.setViewName("/role/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/queryRoleByCondition")
	public StatusResult queryRoleByCondition(
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,
			String condition) {
		logger.info("后台 角色查询");
		return sysRoleService.queryRoleByCondition(pageNum, pageSize, condition);
	}
	
	@GetMapping("/add")
	public ModelAndView addRoleHTML(ModelAndView mv) {
		logger.info("后台 添加角色跳转页面");
		mv.setViewName("/role/add");
		return mv;
	}
	
	//s方案二  在实体里面加字段 mapper 的 resultMap 不映射 （方案一 见addUser)
	@PostMapping("/add")
	@ResponseBody
	public StatusResult addRole(@RequestBody SysRole sysRole) {
		logger.info("后台 添加角色");
		return sysRoleService.saveRole(sysRole);
	}
	
	@GetMapping("/edit/{roleId}")
	public ModelAndView editRoleHTML(ModelAndView mv,@PathVariable Integer roleId) {
		logger.info("后台 编辑角色跳转页面");
		SysRole sysRole = sysRoleService.queryByRoleId(roleId);
		mv.setViewName("/role/edit");
		mv.addObject("sysRole", sysRole);
		return mv;
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public StatusResult editRole(@RequestBody SysRole sysRole) {
		
		return null;
	}
	
}
