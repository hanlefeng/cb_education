package com.cb.order.service.impl;

import com.cb.commentuils.CourseWebVoOrder;
import com.cb.order.client.CourseById;
import com.cb.order.client.Uenter;
import com.cb.order.entity.Member;
import com.cb.order.entity.Order;
import com.cb.order.mapper.OrderMapper;
import com.cb.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.order.util.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-11-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private CourseById courseById;
    @Autowired
    private Uenter uenter;

    @Override
    public String saveOrder(String courseId, String memberIdByJwtToken) {
        Member member = uenter.getMemberById(memberIdByJwtToken);
        CourseWebVoOrder course = courseById.getcourse(courseId);
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());
        order.setCourseId(courseId);
        order.setCourseTitle(course.getTitle());
        order.setCourseCover(course.getCover());
        order.setTeacherName(course.getTeacherName());
        order.setTotalFee(course.getPrice());
        order.setMemberId(memberIdByJwtToken);
        order.setMobile(member.getMobile());
        order.setNickname(member.getNickname());
        order.setStatus(0);
        order.setPayType(1);
        baseMapper.insert(order);
        return order.getOrderNo();

    }
}
