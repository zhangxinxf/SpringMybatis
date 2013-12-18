package com.zx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志
 * 
 * @author 2013
 * 
 */
public class LogExapmle {
   private static Logger logger = LoggerFactory.getLogger(LogExapmle.class);

   public static void main(String[] args) {
      Object o = 12;
      logger.debug("this debug {} ", o);
      logger.info("this info {} ", o);
      logger.warn("this warn {} ", o);
      logger.error("this error {} ", o);
   }
}
