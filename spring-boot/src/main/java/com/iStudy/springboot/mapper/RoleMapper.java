package com.iStudy.springboot.mapper;

import com.iStudy.springboot.entity.Role;
import com.iStudy.springboot.model.User;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleMapper extends Mapper<User>,MySqlMapper<Role> {
}