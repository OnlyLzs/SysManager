package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.system.entity.SysUser;

@Mapper
public interface SysUserMapper {
	
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * @Description 根据用户名查找用户信息
     * @author Jason
     * @date Jan 22, 2019
     * @param username
     * @return
     */
	SysUser queryByUserName(String username);

	/**
	 * @Description 查询符合条件的用户
	 * @author Jason
	 * @date Jan 22, 2019
	 * @param sysUser
	 * @param condition
	 * @return
	 */
	List<SysUser> queryUserByCondition(@Param("sysUser")SysUser sysUser, @Param("condition")String condition);
}