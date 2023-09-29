package com.blending.mailingservice.user.service;

import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String signUp(String id, String name, String pw) {

        // 아이디가 이미 등록되어 있다면
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            return "이미 사용중인 아이디 입니다.";
        }
        // 아이디가 등록되어 있지 않다면
        else {
            User newUser = new User();
            newUser.setId(id);
            newUser.setName(name);
            newUser.setPassword(pw);
            userRepository.save(newUser);
            return "유저 생성 성공";
        }

    }

    public String login(String id, String pw) {

        // 아이디가 존재한다면
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            if(existingUser.get().getPassword().equals(pw)) {
                return "login success";
            }
            else {
                return "pw is incorrect";
            }
        }
        else {
            return "id is not exists";
        }

    }
}
