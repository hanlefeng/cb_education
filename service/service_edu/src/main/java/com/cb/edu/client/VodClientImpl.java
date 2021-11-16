package com.cb.edu.client;

import com.cb.commentuils.R;
import org.springframework.stereotype.Component;

@Component
public class VodClientImpl implements VodClient {
    @Override
    public R deletevdo(String id) {
        return R.error().message("删除视频出错了");
    }
}
