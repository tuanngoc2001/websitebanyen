package com.example.websitebanyen.service.Impl;


import com.example.websitebanyen.model.Role;
import com.example.websitebanyen.repository.RoleRepository;
import com.example.websitebanyen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Iterable<String> findNameRole() {
        return roleRepository.findNameRole();
    }

    @Override
    public Page<Role> findAllByNameContaining(Pageable pageable, String name) {
        return roleRepository.findAllByNameContaining(pageable,name);
    }



}
