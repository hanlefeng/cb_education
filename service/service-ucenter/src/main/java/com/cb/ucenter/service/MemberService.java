package com.cb.ucenter.service;

import com.cb.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.ucenter.entity.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author cb
 * @since 2021-10-28
 */
public interface MemberService extends IService<Member> {

    String login(Member member);

    void register(RegisterVo registerVo);
}
