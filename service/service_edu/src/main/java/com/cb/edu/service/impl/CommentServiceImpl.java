package com.cb.edu.service.impl;

import com.cb.edu.entity.Comment;
import com.cb.edu.mapper.CommentMapper;
import com.cb.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-11-04
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
