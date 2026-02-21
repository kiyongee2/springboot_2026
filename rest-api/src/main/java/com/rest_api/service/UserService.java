package com.rest_api.service;

import com.rest_api.entity.User;
import com.rest_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepo;

    public void save(User user) {
        userRepo.save(user);
    }
}
