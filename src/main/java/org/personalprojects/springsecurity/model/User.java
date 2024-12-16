package org.personalprojects.springsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private String email;
    private String name;
    private String password;

    public User(String name, String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User() {

    }
}
