package com.zx.dao;

import java.util.List;

import com.zx.model.User;

public interface UserMapper {

   public User findUserById(Long id);

   public User findById(Long id);;

   public List<User> findAll();

}
