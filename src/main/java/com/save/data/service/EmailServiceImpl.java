package com.save.data.service;

import com.save.data.dto.MessagePostDto;
import com.save.data.dto.UserConfirmationEmailDto;
import com.save.data.dto.UserPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void sendEmailMessage(MessagePostDto messagePostDto) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(messagePostDto.getFromEmail());
            simpleMailMessage.setTo(messagePostDto.getToEmail());
            simpleMailMessage.setSubject(messagePostDto.getTitle());
            simpleMailMessage.setText(messagePostDto.getMessage());

            javaMailSender.send(simpleMailMessage);
        } catch (Exception ex){
            throw new RuntimeException("Erro ao enviar email " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void sendUserConfirmationEmail(UserPostDto userDto) {

        UserConfirmationEmailDto emailDto = new UserConfirmationEmailDto();
        emailDto.setToEmail(userDto.getEmail());
        emailDto.setTitle("Confirmação de cadastro");
        emailDto.setDescription("Confirmação de cadastro na plataforma.");

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDto.getToEmail());
            simpleMailMessage.setSubject(emailDto.getTitle());
            simpleMailMessage.setText(emailDto.getDescription());


            javaMailSender.send(simpleMailMessage);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao enviar email " + ex.getLocalizedMessage());
        }
    }



}
