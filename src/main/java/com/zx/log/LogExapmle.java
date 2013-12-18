package com.zx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExapmle {
   private static Logger logger = LoggerFactory.getLogger(LogExapmle.class);

   public static void main(String[] args) {
      Object o=12;
      logger.warn("this check {} ",o);
   }
}
