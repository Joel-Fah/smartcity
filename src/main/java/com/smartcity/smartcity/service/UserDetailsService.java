package com.smartcity.smartcity.service;

import com.smartcity.smartcity.model.Admin;
import com.smartcity.smartcity.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AdminRepository adminRepository;

    public UserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword()) // No need to encode, it's already encoded in the database
                .roles(admin.getRole()) // Ensure the role is correct
                .build();
    }
}
