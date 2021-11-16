package com.cb.oss.controller;

import com.cb.commentuils.R;
import com.cb.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;
    @PostMapping("upload")
    public R uploadOssFile(MultipartFile file){
        String url = ossService.uploadFilAvatar(file);

        return R.ok().data("url",url);
    }
}
