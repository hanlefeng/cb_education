package com.cb.ucenter.controller;


import com.cb.commentuils.JwtUtils;
import com.cb.commentuils.R;
import com.cb.ucenter.entity.Member;
import com.cb.ucenter.entity.RegisterVo;
import com.cb.ucenter.service.MemberService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-10-28
 */
@RestController
@RequestMapping("/ucenter")
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("login")
    private R login(@RequestBody Member member){
        String token = memberService.login(member);
        return R.ok().data("token",token);
    }
    @PostMapping("register")
    private R register(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return R.ok();
    }
    @GetMapping("gettoken")
    private R gettoken(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        Member member = memberService.getById(memberId);
        System.out.println("返回了token");
        return R.ok().data("member",member);
    }
    @GetMapping("getMemberById/{id}")
    private Member getMemberById(@PathVariable String id){
        Member member = memberService.getById(id);
        return member;
    }

}

