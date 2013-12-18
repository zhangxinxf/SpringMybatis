package com.zx.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zx.service.impl.ClassesServiceImpl;
import com.zx.service.impl.UserServiceImpl;

/**
 * 基于无spring配置文件实现
 * 
 * @author 2013
 * 
 */
@Configuration
public class ApplicationConfig {

   public @Bean
   UserServiceImpl userService() {
      return new UserServiceImpl();
   }

   public @Bean
   ClassesServiceImpl classesService() {
      return new ClassesServiceImpl();
   }
}
