package com.zx.test;

import java.util.ArrayList;
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
      long start=System.currentTimeMillis();
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      ListIterator<Integer> li= list.listIterator();
      long end=System.currentTimeMillis();
      while (li.hasNext()) {
       System.out.println(li.next());
      }
      System.out.println((end-start));
   }

   public static void vector() {
      Vector<Integer> vector = new Vector<Integer>();
   }

   public static void linked() {
      long start=System.currentTimeMillis();
      LinkedList<Integer> list = new LinkedList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.add(5);
      list.add(6);
      list.add(7);
      ListIterator<Integer> li= list.listIterator();
      long end=System.currentTimeMillis();
      while (li.hasNext()) {
       System.out.println(li.next());
      }
      System.out.println((end-start));
   }

   public static void main(String[] args) {
     // list();
      linked();
   }
}
