package com.smartcity.smartcity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type; // e.g., PHONE, EMAIL, ADDRESS

    @NotNull
    private String value;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}