package com.cb.edu.client;

import com.cb.edu.entity.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-ucenter",fallback = UenterCommentImpl.class)
@Component
public interface UenterComment {
    @GetMapping("/ucenter/getMemberById/{id}")
    public Member getMemberById(@PathVariable("id") String id);
}
