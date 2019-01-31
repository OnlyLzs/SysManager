package com.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	public ModelAndView editUserHTMl(@PathVariable("id")Integer id, ModelAndView mv) {
		logger.info("后台 跳转到编辑用户界面");
		SysUser sysUser = sysUserService.queryById(id);
		List<SysRole> sysRoles = sysRoleService.queryAll();
		List<SysRole> roles = sysRoleService.queryByUserId(id);
		List<Integer> roleIdList = new ArrayList<>();
		for (SysRole role : roles) {
			roleIdList.add(role.getRoleId());
		}
		mv.addObject("roleIdList", roleIdList.toString());
		mv.addObject("sysUser", sysUser);
		mv.addObject("sysRoles", sysRoles);
		mv.setViewName("/user/edit");
		return mv;
	}
	
	/*
	 * @requestbody的含义是在当前对象获取整个http请求的body里面的所有数据,
	 * 并且从@requestbody设计上来说，只获取一次就可以拿到请求body里面的所有数据，
	 * 就没必要出现有多个@requestbody出现在controller的函数的形参列表当中
	 */
	/**
	 * 
	 * @Description 修改用户信息包含角色
	 * @author Jason
	 * @date Jan 28, 2019
	 * @param str 前台传来的参数  包含实体属性，赋予的id
	 * @param mv
	 */
	@PostMapping("/update")
	@ResponseBody
	public StatusResult updateUser(@RequestBody String str) {
		logger.info("后台 用户信息修改");
		
		return sysUserService.updateUser(str);
	}
	
	/*
	 * 前台 ajax 传个 array 这里 用 List<Integer>ids 和 Integer[]  ids 都能接收到
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public StatusResult deleteUser(@RequestParam(value="ids[]") List<Integer>ids) {
		logger.info("后台  用户删除");
		
		return sysUserService.deleteUser(ids);
	}
	
	@GetMapping("/add")
	public ModelAndView addUserHTML(ModelAndView mv) {
		logger.info("后台 添加用户界面跳转");
		List<SysRole> sysRoles = sysRoleService.queryAll();
		mv.addObject("sysRoles", sysRoles);
		mv.setViewName("/user/add");
		return mv;
	}
	
	
	//方案一  字符串接收 然后转json （方案二 见addRole)
	@ResponseBody
	@PostMapping("/add")
	public StatusResult addUser(@RequestBody String userInfo) {
		logger.info("后台 添加用户");
		return sysUserService.saveUser(userInfo);
	}
	
}
