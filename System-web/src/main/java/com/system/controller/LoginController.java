package com.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.common.UserCommon;
import com.system.entity.SysResource;
import com.system.response.StatusResult;
import com.system.service.SysResourceService;
import com.system.service.SysUserService;


/**
 * @class LoginController
 * @author Jason
 * @description
 * @date Jan 8, 2019 4:12:41 PM
 */

@Controller
public class LoginController extends UserCommon {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysResourceService sysResourceService;

	/*@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {

		logger.info("后台  /login 跳转登录");
		return "/login";
	}*/
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model, HttpServletRequest request) {
		
		logger.info("后台 /login 登录");
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			return "/index";
		} catch (AuthenticationException e) {
			model.put("message", e.getMessage());
		}
		return "/login";
	}
	
	@ResponseBody
	@RequestMapping("/sys/queryMenu")
	public StatusResult queryMenu() {
		
		logger.info("后台 /query 查询菜单");
		List<SysResource> menuList = sysResourceService.queryMenuByUserId(getUserId());
		return StatusResult.ok(menuList);
	}
	
}
