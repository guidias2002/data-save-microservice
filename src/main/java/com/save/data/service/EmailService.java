package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import com.save.data.dto.UserConfirmationEmailDto;
import com.save.data.dto.UserPostDto;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmailMessage(MessagePostDto messagePostDto);

    void sendUserConfirmationEmail(UserPostDto userDto);
}
