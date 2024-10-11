package com.save.data.repository;

import com.save.data.entity.UserPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPostRepository extends JpaRepository<UserPostEntity, Long> {
    Optional<UserPostEntity> findByEmailIgnoreCase(String email);
}
