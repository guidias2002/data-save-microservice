package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import com.save.data.entity.MessagePostEntity;
import com.save.data.repository.MessagePostRepository;
import com.save.data.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessagePostServiceImpl implements MessagePostService{

    @Autowired
    private MessagePostRepository messagePostRepository;

    @Autowired
    private UserPostRepository userPostRepository;

    @Override
    public void createMessage(MessagePostDto messagePostDto) {
        messagePostRepository.save(mapMessageDtoToEntity(messagePostDto));
    }

    private MessagePostEntity mapMessageDtoToEntity(MessagePostDto messagePostDto){
        MessagePostEntity messagePostEntity = new MessagePostEntity();

        userPostRepository.findByEmailIgnoreCase(messagePostDto.getFromEmail().trim()).ifPresentOrElse(user -> {
            messagePostEntity.setUserPost(user);

        }, () -> {
            throw new RuntimeException("Email não está vinculado a nenhum usuário: " + messagePostDto.getFromEmail());
        });

        messagePostEntity.setTitle(messagePostDto.getTitle());
        messagePostEntity.setMessage(messagePostDto.getMessage());
        messagePostEntity.setToEmail(messagePostDto.getToEmail());
        messagePostEntity.setFromEmail(messagePostDto.getFromEmail());
        messagePostEntity.setCreatedDate(String.valueOf(new Date()));


        return messagePostEntity;
    }
}
