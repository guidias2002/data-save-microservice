package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import com.save.data.entity.MessagePostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessagePostService {

    void createMessage(MessagePostDto messagePostDto);

}
