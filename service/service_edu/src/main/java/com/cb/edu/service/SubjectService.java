package com.cb.edu.service;

import com.cb.edu.entity.AllSubject.OneSubject;
import com.cb.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author cb
 * @since 2021-09-11
 */
public interface SubjectService extends IService<Subject> {

    void saveSubject(MultipartFile file,SubjectService subjectService);

    List<OneSubject> getallSubject();
}
