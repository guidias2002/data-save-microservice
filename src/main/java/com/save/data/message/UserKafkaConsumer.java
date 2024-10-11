package com.save.data.message;

import com.save.data.dto.UserPostDto;
import com.save.data.service.UserPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserKafkaConsumer {

    private final Logger LOG = LoggerFactory.getLogger(UserKafkaConsumer.class);

    @Autowired
    private UserPostService userPostService;

    @KafkaListener(topics = "user-post-topic", groupId = "user-group", containerFactory = "userkafkaListenerContainerFactory")
    public void listeningUser(UserPostDto userPostDto){
        userPostService.createUser(userPostDto);
    }
}
