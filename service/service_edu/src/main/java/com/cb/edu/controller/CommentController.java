package com.cb.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.commentuils.JwtUtils;
import com.cb.commentuils.R;
import com.cb.edu.client.UenterComment;
import com.cb.edu.entity.Comment;
import com.cb.edu.entity.Member;
import com.cb.edu.service.CommentService;
import com.cb.servicebase.exceptionhandler.CBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-11-04
 */
@RestController
@RequestMapping("/eduservice/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UenterComment uenterComment;
    @GetMapping("getCommentByCourseId/{page}/{size}/{id}")
    private R getCommentByCourseId(@PathVariable Long page,@PathVariable Long size,@PathVariable String id){
        Page<Comment> pageParam = new Page<>(page,size);
        QueryWrapper<Comment> cq = new QueryWrapper<>();
        cq.eq("course_id",id);
        cq.orderByDesc("gmt_create");
        commentService.page(pageParam,cq);
        List<Comment> commentList = pageParam.getRecords();
        Map<String, Object> map = new HashMap<>();
        map.put("items", commentList);
        map.put("current", pageParam.getCurrent());
        map.put("pages", pageParam.getPages());
        map.put("size", pageParam.getSize());
        map.put("total", pageParam.getTotal());
        map.put("hasNext", pageParam.hasNext());
        map.put("hasPrevious", pageParam.hasPrevious());
        return R.ok().data("commentList",map);
    }
    @PostMapping("saveComment")
    private R saveComment(@RequestBody Comment comment, HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if(StringUtils.isEmpty(memberId)){
            throw new CBException(1000,"请登录");
        }
        Member member = uenterComment.getMemberById(memberId);
        comment.setMemberId(memberId);
        comment.setNickname(member.getNickname());
        comment.setAvatar(member.getAvatar());
        commentService.save(comment);
        return R.ok();

    }


}

