package com.cb.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.commentuils.JwtUtils;
import com.cb.commentuils.MD5;
import com.cb.servicebase.exceptionhandler.CBException;
import com.cb.ucenter.entity.Member;
import com.cb.ucenter.entity.RegisterVo;
import com.cb.ucenter.mapper.MemberMapper;
import com.cb.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-10-28
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(Member member) {
        String mobile = member.getMobile();
        String password = member.getPassword();
        if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            throw new CBException(1000,"登陆失败");
        }
        QueryWrapper<Member> qwm = new QueryWrapper<>();
        qwm.eq("mobile",mobile);
        Member member1 = baseMapper.selectOne(qwm);
        if(member1 == null){
            throw new CBException(1000,"登陆失败");
        }
        password = MD5.encrypt(password);
        if(!password.equals(member1.getPassword())){
            throw new CBException(1000,"登陆失败");
        }
        if(member1.getIsDisabled()){
            throw new CBException(1000,"登陆失败");
        }
        String jwtToken = JwtUtils.getJwtToken(member1.getId(), member1.getNickname());
        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();
        if(StringUtils.isEmpty(code)||StringUtils.isEmpty(mobile)||StringUtils.isEmpty(nickname)||StringUtils.isEmpty(password)){
            throw new CBException(1000,"注册失败");
        }
        if(!code.equals(redisTemplate.opsForValue().get(mobile))){
            throw new CBException(1000,"注册失败");
        }
        Integer count = baseMapper.selectCount(new QueryWrapper<Member>().eq("mobile",mobile));
        if(count>0){
            throw new CBException(1000,"注册失败");
        }
            Member member = new Member();
            member.setMobile(mobile);
            member.setPassword(MD5.encrypt(password));
            member.setNickname(nickname);
            baseMapper.insert(member);
    }
}
