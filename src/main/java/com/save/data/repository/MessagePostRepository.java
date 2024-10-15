package com.save.data.repository;

import com.save.data.entity.MessagePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessagePostRepository extends JpaRepository<MessagePostEntity, Long> {
    Optional<MessagePostEntity> findByFromEmail(String email);

}
