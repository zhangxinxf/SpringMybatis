package com.zx.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

/**
 * 集合比较
 * 
 * @author 2013
 * 
 */
public class ArrayCompare {

   public static void list() {
      long start = System.currentTimeMillis();
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      ListIterator<Integer> li = list.listIterator();
      long end = System.currentTimeMillis();
      while (li.hasNext()) {
         System.out.println(li.next());
      }
      System.out.println((end - start));
   }

   public static void vector() {
      Vector<Integer> vector = new Vector<Integer>();
   }

   public static void linked() {
      long start = System.currentTimeMillis();
      LinkedList<Integer> list = new LinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      ListIterator<Integer> li = list.listIterator();
      long end = System.currentTimeMillis();
      while (li.hasNext()) {
         System.out.println(li.next());
      }
      System.out.println((end - start));
   }

   public static void main(String[] args) {
      HashSet<String> hs=new HashSet<>();
      // list();
      // linked();
      /*
       ***
       ******
       ********
       ******
       ***
       */
      int sum = 7;//行数
      int avg = 3;//分割边界
      int line = 3;
      int n = 0;//打印的个数
      for (int i = 0; i <= sum; i++) {
         if (i == 0) {
            n = 1;
         } else if (avg > i) {
            n = i * line;
         } else if (avg == i) {
            n = avg * line - 1;
            i++;
         } else {
            int temp = sum - i;
            if (temp == 0)
               n = 1;
            else
               n = temp * avg;
         }
         for (int j = 1; j <= n; j++) {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}
