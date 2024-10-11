package com.save.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "message_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagePostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message_title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "to_email")
    private String toEmail;

    @Column(name = "message_createdDate")
    private String createdDate;

    @Column(name = "from_email")
    private String fromEmail;

    @ManyToOne
    @JoinColumn(name = "user_post_id", nullable = false, referencedColumnName = "id")
    private UserPostEntity userPost;


}
