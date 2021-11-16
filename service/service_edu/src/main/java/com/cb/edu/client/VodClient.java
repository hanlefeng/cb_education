package com.cb.edu.client;

import com.cb.commentuils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "service-vdo",fallback = VodClientImpl.class)
@Component
public interface VodClient {
    @DeleteMapping("/eduvdo/deletevdo/{id}")
    public R deletevdo(@PathVariable("id") String id);
}
