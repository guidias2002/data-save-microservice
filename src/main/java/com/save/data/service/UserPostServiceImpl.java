package com.save.data.service;

import com.save.data.dto.UserPostDto;
import com.save.data.entity.UserPostEntity;
import com.save.data.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    private UserPostRepository userPostRepository;

    @Override
    public void createUser(UserPostDto userPostDto) {
        userPostRepository.findByEmailIgnoreCase(userPostDto.getEmail()).ifPresentOrElse(user -> {
            throw new RuntimeException("Email já está cadastrado.");
        }, () -> {
            UserPostEntity userPostEntity = mapUserDtoToEntity(userPostDto);
            userPostRepository.save(userPostEntity);
        });
    }

    private UserPostEntity mapUserDtoToEntity(UserPostDto userPostDto){
        UserPostEntity userPostEntity = new UserPostEntity();

        userPostEntity.setName(userPostDto.getName());
        userPostEntity.setEmail(userPostDto.getEmail());
        userPostEntity.setPosition(userPostDto.getPosition());
        userPostEntity.setCreatedDate(String.valueOf(new Date()));

        return userPostEntity;
    }
}
