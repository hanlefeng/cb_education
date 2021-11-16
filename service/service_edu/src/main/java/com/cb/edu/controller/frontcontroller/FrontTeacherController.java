package com.cb.edu.controller.frontcontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.commentuils.R;
import com.cb.edu.entity.Course;
import com.cb.edu.entity.Teacher;
import com.cb.edu.service.CourseService;
import com.cb.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class FrontTeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @GetMapping("getteacher/{page}/{limit}")
    private R getteacher(@PathVariable Long page,@PathVariable Long limit){
        Page<Teacher> pageParam = new Page<>(page, limit);
        Map<String, Object> map = teacherService.pageListWeb(pageParam);
        return R.ok().data("teacherlist",map);
    }
    @GetMapping("getTeacherFrontInfo/{id}")
    private R getTeacherFrontInfo(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        QueryWrapper<Course> qc = new QueryWrapper<>();
        qc.eq("teacher_id",id);
        List<Course> courses = courseService.list(qc);
        return R.ok().data("teacher",teacher).data("courses",courses);
    }
}
