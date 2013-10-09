package com.zx.model;

import java.util.ArrayList;
import java.util.List;

public class Classes {
   private Long id;
   private String name;
   private List<User> users = new ArrayList<User>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public List<User> getUsers() {
      return users;
   }

   public void setUsers(List<User> users) {
      this.users = users;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return "id:\t" + id + "\nname:\t" + name;
   }
}
