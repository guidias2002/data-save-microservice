package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import com.save.data.dto.UserPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserPostService {
    void createUser(UserPostDto userPostDto);


}
