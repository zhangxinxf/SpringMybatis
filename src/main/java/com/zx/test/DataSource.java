package com.zx.test;

public class DataSource implements Source {

   @Override
   public void run() {
      System.out.println("获取数据库连接.....");
   }
}
