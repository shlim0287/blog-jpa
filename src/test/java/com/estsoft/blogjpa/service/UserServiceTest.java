package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.domain.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc
@SpringBootTest
class UserServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext ac;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

//
//    @Test
//    void save() {
//        //given
//        User user=new User("mock_email1","mock_pw1");
//        // when
//        AddUserRequest request=new AddUserRequest(user.getEmail(),user.getPassword());
//        User save = userService.save(request);
//        // then
//        Assertions.assertThat(user.getEmail()).isEqualTo(save.getEmail());
//        Assertions.assertThat(user.getUsername()).isEqualTo(save.getUsername());
//    }


    @Test
    public void existsTest(){
        boolean exists = userRepository.existsById(1L);

        System.out.println(exists);
    }
}