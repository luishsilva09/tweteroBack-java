package com.tweteroo.twetero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.twetero.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByUsername(String username);
}
