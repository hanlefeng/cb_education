package com.cb.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.commentuils.JwtUtils;
import com.cb.commentuils.R;
import com.cb.order.entity.Order;
import com.cb.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-11-05
 */
@RestController
@RequestMapping("/orderservice")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("createdOrder/{courseId}")
    private R save(@PathVariable String courseId, HttpServletRequest request){
        String orderId = orderService.saveOrder(courseId, JwtUtils.getMemberIdByJwtToken(request));
        return R.ok().data("orderId",orderId);
    }
    @GetMapping("getOrderById/{orderId}")
    private R getOrder(@PathVariable String orderId){
        QueryWrapper<Order> oqw = new QueryWrapper<>();
        oqw.eq("order_no",orderId);
        Order order = orderService.getOne(oqw);
        return R.ok().data("order",order);
    }

}

