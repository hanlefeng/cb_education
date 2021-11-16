package com.cb.edu.controller;


import com.cb.commentuils.R;
import com.cb.edu.entity.AllSubject.OneSubject;
import com.cb.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-09-11
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @PostMapping("saveSubject")
    private R addSubject(MultipartFile file){
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }
    @GetMapping("getallSubject")
    private R getallSubject(){
        List<OneSubject> list = subjectService.getallSubject();
        return R.ok().data("list",list);
    }

}

