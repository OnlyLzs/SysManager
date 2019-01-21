package com.system.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysResource {
    private Integer resourceId;

    private String resourceName;

    private String permission;

    private String url;

    private Integer parentId;

    private String type;

    private String description;

    private String createDate;

    private String updateDate;
    
    private List<SysResource> childrenResources;
    
}