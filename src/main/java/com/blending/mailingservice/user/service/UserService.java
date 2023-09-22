package com.blending.mailingservice.user.service;

import com.blending.mailingservice.user.dto.UserSignUpDto;
import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String signUp(UserSignUpDto dto) {

        // 아이디가 이미 등록되어 있다면
        Optional<User> existingUser = userRepository.findById(dto.getId());

        if (existingUser.isPresent()) {
            return "이미 사용중인 아이디 입니다.";
        }
        // 아이디가 등록되어 있지 않다면
        else {
            User newUser = new User();
            newUser.setId(dto.getId());
            newUser.setName(dto.getName());
            newUser.setPassword(dto.getPw());
            userRepository.save(newUser);
            return "유저 생성 성공";
        }

    }
}
