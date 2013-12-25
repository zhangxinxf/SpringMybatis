package com.zx.porxy;

public class BookService implements IBookService {

   @Override
   public String addBook(String name) {
      System.out.println("add " + name + "Book.....");
      return "addBook";
   }

   @Override
   public String updateBook(String name) {
      System.out.println("update" + name + " Book.....");
      return "updateBook";
   }

}
