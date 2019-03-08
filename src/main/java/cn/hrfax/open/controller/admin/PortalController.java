package cn.hrfax.open.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/portal")
@Controller
public class PortalController {

    @RequestMapping("/index.html")
    public String index(){
        return "portal/index0";
    }

    @RequestMapping("/west.html")
    public String west(){
        return "layout/west";
    }

    @RequestMapping("/east.html")
    public String east(){
        return "layout/east";
    }

    @RequestMapping("/south.html")
    public String south(){
        return "layout/south";
    }

    @RequestMapping("/north.html")
    public String north(){
        return "layout/north";
    }

}
