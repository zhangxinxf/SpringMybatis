package com.zx.test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Threads {

   public static void main(String[] args) {
      RunThread run_1 = new RunThread();
      RunThread run_2 = new RunThread();
      run_1.run();
      run_2.run();
      try {
         TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class RunThread implements Runnable {
   private int sum = 0;

   @Override
   public void run() {
      for (int i = 0; i < 100; i++) {
         sum += 1;
      }
      System.out.println(sum);
   }
}