package com.cb.sms.Controller;

import com.cb.commentuils.R;
import com.cb.sms.Service.SmsService;
import com.cb.sms.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smsservice")
@CrossOrigin
public class SmsController {
    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("getcode/{phone}")
    private R getcode(@PathVariable String phone){
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return R.ok();
        }
        code = RandomUtil.getFourBitRandom();
        Boolean success = smsService.getcode(phone,code);
        System.out.println(code);
        if (success){
            redisTemplate.opsForValue().set(phone,code);
            return R.ok();
        }else {
            return R.error();
        }
    }
}
