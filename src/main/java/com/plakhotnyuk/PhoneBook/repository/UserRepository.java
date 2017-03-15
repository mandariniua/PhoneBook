package com.plakhotnyuk.PhoneBook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.plakhotnyuk.PhoneBook.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
