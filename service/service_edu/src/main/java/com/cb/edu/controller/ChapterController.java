package com.cb.edu.controller;


import com.cb.commentuils.R;
import com.cb.edu.entity.AllChapter.OneChapter;
import com.cb.edu.entity.Chapter;
import com.cb.edu.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @GetMapping("getallchapter/{id}")
    private R getallchapter(@PathVariable String id){
        List<OneChapter> list = chapterService.getallchapter(id);
        return R.ok().data("chapterlist",list);
    }
    @PostMapping("savechapter")
    private R savechapter(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return R.ok();
    }
    @DeleteMapping("removeChapterById/{id}")
    private R deleteChapter(@PathVariable String id){
        chapterService.deleteChapter(id);
        return R.ok();
    }
    @PostMapping("updateChapter")
    private R updateChapter(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return R.ok();
    }
    @GetMapping("getChapterById/{id}")
    private R getChapterById(@PathVariable String id){
        Chapter chapter = chapterService.getById(id);
        return R.ok().data("chapter",chapter);
    }

}

