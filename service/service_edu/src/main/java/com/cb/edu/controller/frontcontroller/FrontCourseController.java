package com.cb.edu.controller.frontcontroller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.commentuils.CourseWebVoOrder;
import com.cb.commentuils.R;
import com.cb.edu.entity.AllChapter.OneChapter;
import com.cb.edu.entity.Course;
import com.cb.edu.entity.vo.CourseQueryVo;
import com.cb.edu.entity.vo.CourseWebVo;
import com.cb.edu.service.ChapterService;
import com.cb.edu.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/eduservice/course")
public class FrontCourseController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private CourseService courseService;
    @PostMapping("getcourse/{page}/{size}")
    private R getcourse(@PathVariable Long page, @PathVariable Long size, @RequestBody(required = false) CourseQueryVo courseQueryVo){
        Page<Course> coursePage = new Page<Course>(page,size);
        Map<String, Object> map = courseService.getcourse(coursePage,courseQueryVo);
        System.out.println(map);
        return R.ok().data("course",map);
    }
    @GetMapping("CourseInfo/{id}")
    private R CourseInfo(@PathVariable String id){
        List<OneChapter> allchapter = chapterService.getallchapter(id);
        CourseWebVo courseWebVo = courseService.getCourseInfo(id);
        return R.ok().data("courseInfo",courseWebVo).data("chapters",allchapter);
    }
    @PostMapping("updatePageViewCount/{id}")
    private R updatePageViewCount(@PathVariable String id){
        courseService.updatePageViewCount(id);
        return R.ok();
    }
    @GetMapping("getCourseWebVoOrder/{id}")
    private CourseWebVoOrder getcourse(@PathVariable String id){
        CourseWebVo courseInfo = courseService.getCourseInfo(id);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(courseInfo,courseWebVoOrder);
        return courseWebVoOrder;
    }

}
