package cn.yf.test.springboot01.controller;

import cn.yf.test.springboot01.bean.User;
import cn.yf.test.springboot01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/save")
    public String getting(User user){
       userMapper.insert(user);
       return "redirect:/userInfo";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("name","Dear");
        return "userInfo";
    }

    @RequestMapping("/userInfo")
    public String getUserInfo(Model model){
      List<User> users =  userMapper.getAllUser();
      model.addAttribute("users",users);
        return "userInfo";
    }
    @RequestMapping("/delete")
    public String deleteUser(Integer id){
        userMapper.deleteUser(id);
        return "redirect:/userInfo";
    }

    @RequestMapping("/update")
    public String updateUser(Integer id ,Model model){
       User user =  userMapper.getUserInfo(id);
       model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("/edit")
    public String editUser(User user){
        System.out.println();
        userMapper.editUserInfo(user);
        return "redirect:/userInfo";
    }

}
