package com.cb.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author cb
 * @since 2021-07-17
 */
public interface TeacherService extends IService<Teacher> {


    Map<String, Object> pageListWeb(Page<Teacher> pageParam);
}
