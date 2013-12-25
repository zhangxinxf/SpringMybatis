package com.zx.porxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK代理对象
 * 
 * @author 2013
 * 
 */
public class ProxyService implements InvocationHandler {

   private Object target;

   public Object newProxyInstance(Object target) {
      this.target = target;
      return Proxy.newProxyInstance(target.getClass().getClassLoader(), target
            .getClass().getInterfaces(), this);
   }

   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Object result = null;
      System.out.println("执行前.........");
      result = method.invoke(target, args);
      System.out.println("执行后.........");
      return result;
   }

   public static void main(String[] args) {
      ProxyService proxyService = new ProxyService();
      BookService bookService = new BookService();
      IBookService service = (IBookService) proxyService.newProxyInstance(bookService);
      service.addBook("book");
   }
}
