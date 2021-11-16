package com.cb.order.service.impl;

import com.cb.order.entity.PayLog;
import com.cb.order.mapper.PayLogMapper;
import com.cb.order.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-11-05
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
