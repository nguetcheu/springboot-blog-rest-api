package com.springboot.blog.service;

import com.springboot.blog.dtos.CommentDto;

public interface CommentService {

    CommentDto createComment(Long postId, CommentDto commentDto);
}
