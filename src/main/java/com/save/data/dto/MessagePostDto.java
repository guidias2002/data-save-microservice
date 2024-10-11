package com.save.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class MessagePostDto {

    private String title;
    private String message;
    private String toEmail;
    private String createdDate;
    private String fromEmail;
    private String userName;

}

