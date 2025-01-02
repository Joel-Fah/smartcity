package com.smartcity.smartcity.repository;

import com.smartcity.smartcity.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Additional query methods (if any) can be added here
}
