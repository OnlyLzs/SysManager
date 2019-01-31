package com.system.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysRole {
    private Integer roleId;

    private String roleName;

    private String description;

    private String createDate;

    private String updateDate;
    
    private List<Integer> resourceIds;

   
}