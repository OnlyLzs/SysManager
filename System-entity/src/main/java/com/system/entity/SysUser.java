package com.system.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysUser {
    private Integer userId;

    private String userName;

    private String password;

    private String mobile;

    private String email;

    private String createDate;

    private String updateDate;

    private String remake;
    
    private Integer status;

    private List<SysRole> roles;
    
    //private String roleIds;
}