package org.personalprojects.springsecurity.repository;

import org.personalprojects.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Optional;

//@Repository
//public interface UserRepository extends JpaRepository<User, String>{
//
//    static final String INSERT = "INSERT INTO authentication.user (name, email, password) VALUES(:name,:email,:password)";
//    static final String FIND_BY_EMAIL = "SELECT * FROM authentication.user WHERE email=:email";
//
//    @Query(value=INSERT, nativeQuery = true)
//    public void add(User user);
//
//    @Query(value=FIND_BY_EMAIL, nativeQuery = true)
//    public Optional<User> findByEmail(String email);
//}

@Repository
public class UserRepository {
    static final String INSERT = "INSERT INTO authentication.user (name, email, password) VALUES(:name,:email,:password)";
    static final String FIND_BY_EMAIL = "SELECT * FROM authentication.user WHERE email=:email";

    private final JdbcClient jdbcClient;
    public UserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void add(User user) {
        long affected = jdbcClient.sql(INSERT)
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("password", user.getPassword())
                .update();
        Assert.isTrue(affected==1, "COULD NOT ADD USER.");
    }

    public Optional<User> findByEmail(String email) {
        return jdbcClient.sql(FIND_BY_EMAIL)
                .param("email", email)
                .query(User.class)
                .optional();
    }
}