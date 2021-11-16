package com.cb.vdo.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.cb.commentuils.R;
import com.cb.servicebase.exceptionhandler.CBException;
import com.cb.vdo.service.Vdoservice;
import com.cb.vdo.utils.ConstantPropertiesUtil;
import com.cb.vdo.utils.InitVodClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduvdo")
@CrossOrigin
public class vdocontroller {
    @Autowired
    private Vdoservice vdoservice;

    @PostMapping("uploadvdo")
    private R uploadvdo(MultipartFile file) {
        String id = vdoservice.uploadvdo(file);
        return R.ok().data("id", id);
    }

    @DeleteMapping("deletevdo/{id}")
    private R deletevdo(@PathVariable String id) {
        try {
            DefaultAcsClient client = InitVodClient.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(id);
            client.getAcsResponse(request);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CBException(20000, "删除视频异常");
        }
    }

    @GetMapping("get-play-auth/{videoId}")
    private R getVideoPlayAuth(@PathVariable String videoId) throws
            Exception {
        //获取阿里云存储相关常量
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        //初始化
        DefaultAcsClient client = InitVodClient.initVodClient(accessKeyId,
                accessKeySecret);
        //请求
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);
        //响应
        GetVideoPlayAuthResponse response = client.getAcsResponse(request);
        //得到播放凭证
        String playAuth = response.getPlayAuth();
        //返回结果
        return R.ok().message("获取凭证成功").data("playAuth", playAuth);
    }
}
