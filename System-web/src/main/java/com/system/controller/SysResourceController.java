package com.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.entity.SysResource;
import com.system.response.StatusResult;
import com.system.service.SysResourceService;
import com.system.utils.ZtreeBean;

/**
 * 系统资源权限controller
 * @class SysResourceController
 * @author Jason
 * @description
 * @date Jan 31, 2019 11:33:03 AM
 */
@Controller
@RequestMapping("/sys/resource")
public class SysResourceController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SysResourceService sysResourceService;
	
	@ResponseBody
	@GetMapping("/queryAll")
	public StatusResult queryAll() {
		logger.info("后台 查询所有resource");
		List<SysResource> resourceList = sysResourceService.queryAll();
		List<ZtreeBean> ztreeList = new ArrayList<>();
		for (SysResource resource : resourceList) {
			ZtreeBean ztree = new ZtreeBean();
			ztree.setpId(resource.getParentId() + "");
			ztree.setName(resource.getResourceName());
			ztree.setOpen(null + "");
			ztree.setChkDisabled("false");
            ztree.setId(resource.getResourceId() + "");

            ztreeList.add(ztree);
		}
		return StatusResult.ok(ztreeList);
	}
	
	@GetMapping("/queryByRoleId/{roleId}")
	@ResponseBody
	public StatusResult queryByRoleId(@PathVariable("roleId") Integer roleId) {
		logger.info("后台 根据roleId查询Resource");
		
		return sysResourceService.queryByRoleId(roleId);
	}

}
