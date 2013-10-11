package com.zx.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zx.dao.UserMapper;
import com.zx.model.User;

@DirtiesContext
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
public class SpringTestUtils extends AbstractJUnit4SpringContextTests {

   @Autowired
   private UserMapper userMapper;

   @Test
   public void testUser() {
      User user = userMapper.findById(1L);
      assertEquals(user.getUserName(), "方斌");
   }
}
