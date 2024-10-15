package com.save.data.dto;

import lombok.Data;

@Data
public class UserConfirmationEmailDto {
    private String toEmail;
    private String title;
    private String description;

}
