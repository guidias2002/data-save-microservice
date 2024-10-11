package com.save.data.service;

import com.save.data.dto.UserPostDto;
import org.springframework.stereotype.Service;

@Service
public interface UserPostService {
    void createUser(UserPostDto userPostDto);
}
