package com.zx.model;

public class User {
   private Integer id;
   private String userName;
   private String loginName;
   private Classes classes;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getLoginName() {
      return loginName;
   }

   public void setLoginName(String loginName) {
      this.loginName = loginName;
   }

   public Classes getClasses() {
      return classes;
   }

   public void setClasses(Classes classes) {
      this.classes = classes;
   }

   @Override
   public String toString() {
      return "userName:" + userName + "------loginName:" + loginName;
   }
}
