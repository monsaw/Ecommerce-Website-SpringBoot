package com.example.ecommercesite.repository;

import com.example.ecommercesite.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("lawalafeez.com");
        user.setPassword("afeez");
        user.setFirstName("lawal");
        user.setLastName("akano");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertEquals(existUser.getEmail(),user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "lawal@gmail.com";
        User user =repo.findByEmail(email);
        assertEquals(user.getEmail(),email);

    }

}