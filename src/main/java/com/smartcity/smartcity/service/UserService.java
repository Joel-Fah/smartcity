package com.smartcity.smartcity.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.smartcity.smartcity.model.User;

@Service
public class UserService {

    public List<User> getAllUsers() {
        // Mocked data or logic to retrieve users from database
        return List.of(new User("John Doe"), new User("Jane Smith")); // Example
    }
}
