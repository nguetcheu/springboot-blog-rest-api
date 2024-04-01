package com.springboot.blog.service;

import com.springboot.blog.dtos.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
