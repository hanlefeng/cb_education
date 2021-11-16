package com.cb.edu.service;

import com.cb.edu.entity.AllChapter.OneChapter;
import com.cb.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
public interface ChapterService extends IService<Chapter> {

    List<OneChapter> getallchapter(String id);

    void deleteChapter(String id);

}
