package com.springboot.blog.service;

import com.springboot.blog.dtos.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
