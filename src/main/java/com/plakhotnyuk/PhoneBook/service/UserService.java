package com.plakhotnyuk.PhoneBook.service;

import com.plakhotnyuk.PhoneBook.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
