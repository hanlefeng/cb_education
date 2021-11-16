package com.cb.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.edu.entity.AllChapter.OneChapter;
import com.cb.edu.entity.AllChapter.TwoVideo;
import com.cb.edu.entity.Chapter;
import com.cb.edu.entity.Video;
import com.cb.edu.mapper.ChapterMapper;
import com.cb.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.edu.service.VideoService;
import com.cb.servicebase.exceptionhandler.CBException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private VideoService videoService;

    @Override
    public List<OneChapter> getallchapter(String id) {
        QueryWrapper<Chapter> cqw = new QueryWrapper<>();
        cqw.eq("course_id",id);
        List<Chapter> chapters = baseMapper.selectList(cqw);
        QueryWrapper<Video> vqw = new QueryWrapper<>();
        cqw.eq("course_id",id);
        List<Video> videos = videoService.list(vqw);
        List<OneChapter> oneChapterList = new ArrayList<>();
        for(Chapter chapter:chapters){
            OneChapter oneChapter = new OneChapter();
            BeanUtils.copyProperties(chapter,oneChapter);
            List<TwoVideo> twoVideoList = new ArrayList<>();
            for (Video video:videos){
                if (video.getChapterId().equals(chapter.getId())){
                    TwoVideo twoVideo = new TwoVideo();
                    BeanUtils.copyProperties(video,twoVideo);
                    twoVideoList.add(twoVideo);
                }
            }
            oneChapter.setChildren(twoVideoList);
            oneChapterList.add(oneChapter);
        }

        return oneChapterList;
    }

    @Override
    public void deleteChapter(String id) {
        QueryWrapper<Video> qwv = new QueryWrapper<>();
        qwv.eq("chapter_id",id);
        int count = videoService.count(qwv);
        if (count!=0){
            throw new CBException(18888,"请删除小节");
        }else{
            baseMapper.deleteById(id);
        }
    }

}
