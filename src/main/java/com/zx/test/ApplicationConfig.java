package com.zx.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 private static  Logger logger=LoggerFactory.getLogger(ApplicationConfig.class);

   public @Bean
   UserServiceImpl userService() {
      return new UserServiceImpl();
   }

   public @Bean
   ClassesServiceImpl classesService() {
      return new ClassesServiceImpl();
   }
   
   public static void main(String[] args) {
      Object o=12;
      logger.trace("======trace");  
      logger.debug("======debug");  
      logger.info("======info");  
      logger.warn("======warn");  
      logger.error("======error"); 
      logger.debug("this debug {} ", o);
      logger.info("this info {} ", o);
      logger.warn("this warn {} ", o);
      logger.error("this error {} ", o);
   }
}
