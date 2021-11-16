package com.cb.order.client;

import com.cb.commentuils.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-edu",fallback = CourseByIdImpl.class)
@Component
public interface CourseById {
    @GetMapping("/eduservice/course/getCourseWebVoOrder/{id}")
    public CourseWebVoOrder getcourse(@PathVariable("id") String id);
}
