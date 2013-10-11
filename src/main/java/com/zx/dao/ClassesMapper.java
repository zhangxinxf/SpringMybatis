package com.zx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zx.model.Classes;

@Repository("classesMapper")
public interface ClassesMapper {

   public Classes findById(Integer id);

   public List<Classes> findAll();
   
   public int insert(Map<String, Object> data);
   
}
