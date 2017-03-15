package com.plakhotnyuk.PhoneBook.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.plakhotnyuk.PhoneBook.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
