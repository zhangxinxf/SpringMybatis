package com.zx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zx.model.User;




@Repository("userMapper")
public interface UserMapper {

   public User findUserById(Long id);

   public User findById(Long id);;

   public List<User> findAll();

}
