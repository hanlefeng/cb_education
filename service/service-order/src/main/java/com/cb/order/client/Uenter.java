package com.cb.order.client;

import com.cb.order.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-ucenter",fallback = UenterImpl.class)
@Component
public interface Uenter {
    @GetMapping("/ucenter/getMemberById/{id}")
    public Member getMemberById(@PathVariable("id") String id);
}
