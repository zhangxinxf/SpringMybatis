package com.zx.memcache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.ConnectionObserver;
import net.spy.memcached.MemcachedClient;

/**
 * 客户端
 * 
 * @author 2013
 * 
 */
public class Client {
   private static MemcachedClient memcachedClient;
   private static String url = "192.168.204.129";
   private static int port = 11211;

   private Client() {

   }

   static {
      if (memcachedClient == null) {
         memcachedClient = MemcacheConnection.getmemcachedInstance();
      }
   }

   /**
    * 关闭
    */
   public static void disConnect() {
      if (memcachedClient == null) {
         return;
      }
      memcachedClient.shutdown(3, TimeUnit.SECONDS);
   }

   public void addObserver(ConnectionObserver obs) {
      memcachedClient.addObserver(obs);
   }

   /*
    * 构建内部类初始化连接
    */
   private static class MemcacheConnection {
      public static MemcachedClient getmemcachedInstance() {
         try {
            memcachedClient = new MemcachedClient(new InetSocketAddress(url, port));
         } catch (IOException e) {
            e.printStackTrace();
            return null;
         }
         return memcachedClient;
      }
   }

   public static void setValue(String name, Object value) {
      memcachedClient.set(name, 60, value);
   }

   public static Object getName(String name) {
      return memcachedClient.get(name);
   }

   public static Object getAyncName(String name) {
      Future<Object> f = memcachedClient.asyncGet(name);
      try {
         Object myObj = f.get(5, TimeUnit.SECONDS);
         return myObj;
      } catch (TimeoutException e) {
         f.cancel(false);
      } catch (InterruptedException e) {
         f.cancel(false);
      } catch (ExecutionException e) {
         f.cancel(false);
      }
      return null;
   }

   public static void main(String[] args) {
      // Client.setValue("name", "xf_xin");
      // System.out.println(Client.getAyncName("name"));
      // Client.disConnect();
      try {
         MemcachedClient c = new MemcachedClient(new BinaryConnectionFactory(),
               AddrUtil.getAddresses("192.168.204.129:11211 "));
         File file = new File("c://后端存储协议格式.txt");
         InputStream in = new FileInputStream(file);
         byte[] b = new byte[(int) file.length()];
         in.read(b);
         c.set("name", 10, b);
         c.set("name", 10, "abc");
         System.out.println(c.get("name"));
         in.close();
         c.shutdown();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
