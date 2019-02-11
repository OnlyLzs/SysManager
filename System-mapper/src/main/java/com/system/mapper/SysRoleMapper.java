package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.system.entity.SysRole;

@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

	List<SysRole> queryAll();

	List<SysRole> queryByUserId(Integer userId);

	List<SysRole> queryByCondition(String condition);

	/**
	 * @Description 根据ids 删除角色
	 * @author Jason
	 * @date Feb 11, 2019
	 * @param ids
	 * @return
	 */
	int deleteByRoleIds(List<Integer> ids);
}