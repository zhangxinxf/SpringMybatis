package com.zx.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zx.model.Classes;
import com.zx.model.User;

public class Run {

   @Test
   public void TestExceute() {
      ExecutorService executor = Executors.newFixedThreadPool(1);
      // TaskThread taskThread = new TaskThread();
      FutureTask<String> future = new FutureTask<String>(new Callable<String>() {// 使用Callable接口作为构造参数
               public String call() {
                  // 真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                  for (int i = 0; i < 10000; i++) {
                     // 同步阻塞获取信号量
                     System.out.println(i);
                  }
                  return "123";
               }
            });
      executor.execute(future);
      try {
         String lg = future.get(30, TimeUnit.SECONDS);
         System.out.println(lg);
         System.out.println("你好......");
      } catch (InterruptedException | ExecutionException | TimeoutException e) {
         future.cancel(true);
         System.out.println("出异常了 我去......");
      } finally {
         executor.shutdownNow();
      }
      System.out.println("执行完成......");
      boolean cancelResult = future.cancel(true);
      System.out.println(executor.isShutdown());
      System.out.println("删除结果：" + cancelResult);
      while (!executor.isTerminated()) {
      }
   }

   public static void main(String[] args) {
      String resource = "com/zx/model/mybatis-config.xml";
      SqlSession session = null;
      try {
         InputStream inputStream = Resources.getResourceAsStream(resource);
         SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
               .build(inputStream);
         session = sqlSessionFactory.openSession();
         /*
          * UserMapper mapper = session.getMapper(UserMapper.class); User user =
          * mapper.findUserById(1L);
          * System.out.println(user.getClasses().getName());
          * System.out.println(user.toString()); User user =
          * session.selectOne("com.zx.dao.UserMapper.findUserById", 1L);
          * List<User> userList = mapper.findAll(); for (User user : userList) {
          * } //
          */
//         Long startTime = System.currentTimeMillis();
         UserMapper mapper = session.getMapper(UserMapper.class);
         User user = mapper.findById(1L);
         System.out.println(user);
         // Long endTime = System.currentTimeMillis();
         // System.out.println(endTime-startTime);
         // ClassesMapper classesMapper =
         // session.getMapper(ClassesMapper.class);
         // HashMap<String, Object> data = new HashMap<String, Object>();
         // data.put("name", "高三四班");
         // classesMapper.insert(data);

         // Classes classes = classesMapper.findById(1);
         // System.out.println(classes.toString());
         // List<User> users = classes.getUsers();
         // for (User user : users) {
         // System.err.println(user.toString());
         // }
      } catch (IOException exception) {
         exception.printStackTrace();
      } finally {
         session.commit();
         if (session != null) {
            session.close();
         }
      }
   }
}