package com.cb.edu.controller;

import com.cb.commentuils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("eduservice/Teacher")
@CrossOrigin
public class EduLoginController {
    @PostMapping("login")
    public R Login(){
        return R.ok().data("token","admin");
    }
    @GetMapping("getInfo")
    public R getInfo(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
