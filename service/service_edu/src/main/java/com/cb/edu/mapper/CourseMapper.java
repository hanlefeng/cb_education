package com.cb.edu.mapper;

import com.cb.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cb.edu.entity.vo.CoursePublishVo;
import com.cb.edu.entity.vo.CourseWebVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
public interface CourseMapper extends BaseMapper<Course> {
    public CoursePublishVo getCoursePublishVo(String id);

    CourseWebVo getCourseInfo(String id);
}
