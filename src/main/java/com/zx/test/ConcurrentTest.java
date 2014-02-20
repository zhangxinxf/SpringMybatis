package com.zx.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentTest {

   /**
    * 线程同步与唤醒
    * 
    * @param args
    */
   /*
    * public static void main(String[] args) { final ReentrantLock reentrantLock
    * = new ReentrantLock(); final Condition condition =
    * reentrantLock.newCondition();
    * 
    * Thread thread = new Thread(new Runnable() {
    * 
    * @Override public void run() { try { reentrantLock.lock();
    * System.out.println("我要等一个新信号" + this); condition.await(); } catch
    * (InterruptedException e) { e.printStackTrace(); }
    * System.out.println("拿到一个信号！！" + this); reentrantLock.unlock(); } },
    * "waitThread");
    * 
    * thread.start();
    * 
    * Thread thread1 = new Thread(new Runnable() {
    * 
    * @Override public void run() { reentrantLock.lock();
    * System.out.println("我拿到锁了"); try { Thread.sleep(3000); } catch
    * (InterruptedException e) { e.printStackTrace(); } condition.signalAll();
    * System.out.println("我发了一个信号！！"); reentrantLock.unlock(); } },
    * "signalThread");
    * 
    * Thread thread2 = new Thread(new Runnable() {
    * 
    * @Override public void run() { try { reentrantLock.lock();
    * System.out.println("只需等待...." + this); condition.await(); } catch
    * (InterruptedException e) { e.printStackTrace(); }
    * System.out.println("只需等待...." + this); reentrantLock.unlock(); } },
    * "thread2"); thread2.start();
    * 
    * thread1.start(); }
    */

   public static class ReadWriteLockTest {
      // 锁
      ReadWriteLock lock = new ReentrantReadWriteLock();
      // 值
      double value = 0d;
      int addtimes = 0;

      /**
       * 增加value的值，不允许多个线程同时进入该方法
       */
      public void addValue(double v) {
         // 得到writeLock并锁定
         Lock writeLock = lock.writeLock();
         writeLock.lock();
         System.out.println("ReadWriteLockTest to addValue: " + v + "   "
               + System.currentTimeMillis());
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
         try {
            // 做写的工作
            this.value += v;
            this.addtimes++;
            System.out.println("addValue value:" + value);
         } finally {
            // 释放writeLock锁
            writeLock.unlock();
         }
      }

      /**
       * 获得信息。当有线程在调用addValue方法时，getInfo得到的信息可能是不正确的。
       * 所以，也必须保证该方法在被调用时，没有方法在调用addValue方法。
       */
      public String getInfo() {
         // 得到readLock并锁定
         Lock readLock = lock.readLock();
         readLock.lock();
         System.out.println("ReadWriteLockTest to getInfo   "
               + System.currentTimeMillis());
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
         try {
            // 做读的工作
            return this.value + " : " + this.addtimes;
         } finally {
            // 释放readLock
            readLock.unlock();
         }
      }
   }

   public static void testReadWriteLockTest() throws Exception {
      final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
      // 新建任务1，调用lockTest的addValue方法
      Runnable task_1 = new Runnable() {
         public void run() {
            readWriteLockTest.addValue(55.55);
         }
      };
      // 新建任务2，调用lockTest的getValue方法
      Runnable task_2 = new Runnable() {
         public void run() {
            System.out.println("info: " + readWriteLockTest.getInfo());
         }
      };
      // 新建任务执行服务
      ExecutorService cachedService_1 = Executors.newCachedThreadPool();
      Future future_1 = null;
      // 同时执行5个任务，其中前2个任务是task_1，后两个任务是task_2
      for (int i = 0; i < 2; i++) {
         future_1 = cachedService_1.submit(task_1);
      }
      for (int i = 0; i < 2; i++) {
         future_1 = cachedService_1.submit(task_2);
      }
      // 最后一个任务是task_1
      future_1 = cachedService_1.submit(task_1);
      // 这5个任务的执行顺序应该是：
      // 第一个task_1先执行，第二个task_1再执行；这是因为不能同时写，所以必须等。
      // 然后2个task_2同时执行；这是因为在写的时候，就不能读，所以都等待写结束，
      // 又因为可以同时读，所以它们同时执行
      // 最后一个task_1再执行。这是因为在读的时候，也不能写，所以必须等待读结束后，才能写。

      // 等待最后一个task_2被执行完
      future_1.get();
      cachedService_1.shutdownNow();
   }

   public static void main(String[] args) throws Exception {
      ConcurrentTest.testReadWriteLockTest();
   }
}
