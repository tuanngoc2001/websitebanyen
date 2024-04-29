package com.example.websitebanyen.repository;


import com.example.websitebanyen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    Optional<User> findById(int id);
    Iterable<User>findAllByUsernameContaining(String name);


}
