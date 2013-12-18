package com.zx.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zx.dao.UserMapper;
import com.zx.model.User;

@DirtiesContext
@ContextConfiguration(locations = { "classpath*:spring/applicationContext.xml" })
// @Configuration 要加入cglib增强代理
@ActiveProfiles("production")
public class SpringTestUtils extends AbstractJUnit4SpringContextTests {

   @Autowired
   private UserMapper userMapper;

   @Test
   public void testUser() {
      User user = userMapper.findById(1L);
      assertEquals(user.getUserName(), "方斌");
      // 手动释放资源
      AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
      abstractApplicationContext.close();
   }
}
