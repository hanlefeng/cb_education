package com.cb.cms.controller;


import com.cb.cms.entity.CrmBanner;
import com.cb.cms.service.CrmBannerService;
import com.cb.commentuils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-10-26
 */
@RestController
@RequestMapping("/cms")
@CrossOrigin
public class CrmBannerController {
    @Autowired
    private CrmBannerService crmBannerService;
    @GetMapping("getallbanner")
    private R getallbanner(){
        List<CrmBanner> list = crmBannerService.getallbanner();
        return R.ok().data("banner",list);
    }


}

