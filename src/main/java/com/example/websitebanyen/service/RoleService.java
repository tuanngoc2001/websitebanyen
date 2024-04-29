package com.example.websitebanyen.service;



import com.example.websitebanyen.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
    Iterable<String>findNameRole();
    Page<Role> findAllByNameContaining(Pageable pageable, String name);
}
