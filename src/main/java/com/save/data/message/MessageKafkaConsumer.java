package com.save.data.message;

import com.save.data.dto.MessagePostDto;
import com.save.data.service.MessagePostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageKafkaConsumer {

    private final Logger LOG = LoggerFactory.getLogger(UserKafkaConsumer.class);

    @Autowired
    private MessagePostService messagePostService;

    @KafkaListener(topics = "message-post-topic", groupId = "message-group", containerFactory = "messagekafkaListenerContainerFactory")
    public void listeningMessage(MessagePostDto messagePostDto){
        messagePostService.createMessage(messagePostDto);
    }
}
