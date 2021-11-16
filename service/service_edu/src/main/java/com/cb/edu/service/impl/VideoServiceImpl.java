package com.cb.edu.service.impl;

import com.cb.edu.entity.Video;
import com.cb.edu.mapper.VideoMapper;
import com.cb.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-10-12
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

}
