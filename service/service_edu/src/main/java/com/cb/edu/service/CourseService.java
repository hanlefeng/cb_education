package com.cb.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.edu.entity.vo.CourseInfoVo;
import com.cb.edu.entity.vo.CoursePublishVo;
import com.cb.edu.entity.vo.CourseQueryVo;
import com.cb.edu.entity.vo.CourseWebVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
public interface CourseService extends IService<Course> {

    String savecourse(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseById(String id);

    void updateCourse(CourseInfoVo courseInfoVo);

    CoursePublishVo getCoursePublishVo(String id);

    Map<String, Object> getcourse(Page<Course> coursePage, CourseQueryVo courseQueryVo);

    CourseWebVo getCourseInfo(String id);

    void updatePageViewCount(String id);
}
