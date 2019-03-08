package cn.hrfax.open.controller.admin;

import cn.hrfax.open.model.UserPo;
import cn.hrfax.open.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/views/login.html")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<UserPo> list(){
        return userService.list();
    }

}
