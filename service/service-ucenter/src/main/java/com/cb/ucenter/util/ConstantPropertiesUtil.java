package com.cb.ucenter.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtil implements InitializingBean {
    @Value("${wx.open.app_id}")
    private String id;
    @Value("${wx.open.app_secret}")
    private String secret;
    @Value("${wx.open.redirect_url}")
    private String url;
    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;
    public static String WX_OPEN_REDIRECT_URL;
    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = id;
        WX_OPEN_APP_SECRET = secret;
        WX_OPEN_REDIRECT_URL = url;
    }
}
