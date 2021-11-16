package com.cb.edu.controller;


import com.cb.commentuils.R;
import com.cb.edu.client.VodClient;
import com.cb.edu.entity.Video;
import com.cb.edu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private VodClient vodClient;
    @PostMapping("saveVideo")
    private R saveVideo(@RequestBody Video video){
        videoService.save(video);
        return R.ok();
    }
    @GetMapping("getVideoById/{id}")
    private R getVideoById(@PathVariable String id){
        Video video = videoService.getById(id);
        return R.ok().data("video",video);
    }
    @PostMapping("updateVideo")
    private R updateVideo(@RequestBody Video video){
        videoService.updateById(video);
        return R.ok();
    }
    @DeleteMapping("deletevideo/{id}")
    private R deletevideo(@PathVariable String id){
        Video video = videoService.getById(id);
        String videoSourceId = video.getVideoSourceId();
        if(!StringUtils.isEmpty(videoSourceId)){
            vodClient.deletevdo(videoSourceId);
        }
        videoService.removeById(id);
        return R.ok();
    }
}

