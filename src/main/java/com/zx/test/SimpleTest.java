package com.zx.test;

import javax.sql.DataSource;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zx.dao.UserMapper;
import com.zx.model.User;

/**
 * 基于junit测试
 * 
 * @author 2013
 * 
 */
public class SimpleTest {
   private static UserMapper userMapper;
   private static DataSource dataSource;

   @BeforeClass
   public static void init() {
      ApplicationContext context = new ClassPathXmlApplicationContext(
            "classpath*:spring/applicationContext.xml");
      userMapper = (UserMapper) context.getBean("userMapper");
      dataSource = (DataSource) context.getBean("dataSource");
   }

   @Test
   public void testFindUserById() {
      User user = userMapper.findById(1L);
      assertEquals("方斌",user.getUserName());
   }
}
