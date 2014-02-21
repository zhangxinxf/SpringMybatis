package com.zx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户信息controller
 * 
 * @author 2013
 * 
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
   /*
    * 用户信息列表
    */
   @RequestMapping(value="/list")
   public ModelAndView list() {
      ModelAndView view = new ModelAndView();
      view.setViewName("/user/list");
      return view;
   }
}
