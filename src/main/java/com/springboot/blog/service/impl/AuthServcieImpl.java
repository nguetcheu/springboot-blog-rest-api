package com.springboot.blog.service.impl;

import com.springboot.blog.dtos.LoginDto;
import com.springboot.blog.dtos.RegisterDto;
import com.springboot.blog.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServcieImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    public AuthServcieImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(LoginDto loginDto) {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 loginDto.getUserNameOrEmail(), loginDto.getPassword())
         );

        SecurityContextHolder.getContext().setAuthentication(authentication);

         return "User Logged successfully!.";
    }

    @Override
    public String register(RegisterDto registerDto) {
        return null;
    }
}
