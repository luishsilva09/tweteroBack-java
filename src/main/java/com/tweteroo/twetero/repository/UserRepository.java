package com.tweteroo.twetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.twetero.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {}
