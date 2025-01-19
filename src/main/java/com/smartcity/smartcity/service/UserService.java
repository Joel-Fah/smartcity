package com.smartcity.smartcity.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.smartcity.smartcity.model.User;

@Service
public class UserService {

    public List<User> getAllUsers() {
        // Return a list of users (this is just a mock implementation)
        return List.of(new User("John Doe"), new User("Jane Smith"));
    }
}
