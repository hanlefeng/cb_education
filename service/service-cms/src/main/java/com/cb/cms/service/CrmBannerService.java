package com.cb.cms.service;

import com.cb.cms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author cb
 * @since 2021-10-26
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> getallbanner();
}
