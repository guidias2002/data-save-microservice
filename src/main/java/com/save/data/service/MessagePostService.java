package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import org.springframework.stereotype.Service;

@Service
public interface MessagePostService {

    void createMessage(MessagePostDto messagePostDto);
}
