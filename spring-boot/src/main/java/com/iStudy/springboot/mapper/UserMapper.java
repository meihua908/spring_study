/**
 * 
 */
package com.iStudy.springboot.mapper;

import java.util.List;

import com.iStudy.springboot.model.User;

/**
 * @author Administrator
 *
 */
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>, tk.mybatis.mapper.common.MySqlMapper<User>{

    List<User> getAll();

    User getOne(Long id);
    
    void insertUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(Long id);
}
