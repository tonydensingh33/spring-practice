package dev.spring.practice1.service;

import dev.spring.practice1.models.User;
import dev.spring.practice1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User createUser(User User) {
        return UserRepository.save(User);
    }

    public User getUser(Long id) {
        return UserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
