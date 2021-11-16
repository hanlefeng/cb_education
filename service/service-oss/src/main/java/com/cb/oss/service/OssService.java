package com.cb.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {


    String uploadFilAvatar(MultipartFile file);
}
