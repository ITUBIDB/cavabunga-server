package edu.itu.cavabunga.user;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFactory {
    public User createUser(String user_name){
        return new User(user_name);
    }
}
