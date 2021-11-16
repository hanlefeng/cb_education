package com.cb.edu.controller;


import com.cb.commentuils.R;
import com.cb.edu.entity.Course;
import com.cb.edu.entity.vo.CourseInfoVo;
import com.cb.edu.entity.vo.CoursePublishVo;
import com.cb.edu.entity.vo.CourseWebVo;
import com.cb.edu.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("saveCourse")
    private R saveCourse(@RequestBody CourseInfoVo courseInfoVo){
        String id = courseService.savecourse(courseInfoVo);
        return R.ok().data("id",id);
    }
    @GetMapping("getCourseById/{id}")
    private R getCourseById(@PathVariable String id){
        CourseInfoVo courseInfoVo = courseService.getCourseById(id);
        return R.ok().data("course",courseInfoVo);
    }
    @PostMapping("updateCourse")
    private R updateCourse(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourse(courseInfoVo);
        return R.ok();
    }
    @GetMapping("getCoursePublishVo/{id}")
    private R getCoursePublishVo(@PathVariable String id){
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);
        return R.ok().data("coursePublishVo",coursePublishVo);
    }
    @PostMapping("publishCourse/{id}")
    private R publishCourse(@PathVariable String id){
        Course course = new Course();
        course.setStatus("Normal");
        course.setId(id);
        courseService.updateById(course);
        return R.ok();
    }

}

