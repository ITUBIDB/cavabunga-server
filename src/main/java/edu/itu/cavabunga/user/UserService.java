package edu.itu.cavabunga.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFactory userFactory;

    public User createUser(String user_name){
        User temp = userFactory.createUser(user_name);
        temp.setCreationDate(new Date());
        userRepository.save(temp);
        return temp;
    }

}
