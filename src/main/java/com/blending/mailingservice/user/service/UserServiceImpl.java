package com.blending.mailingservice.user.service;

import com.blending.mailingservice.user.dto.UserLoginReq;
import com.blending.mailingservice.user.dto.UserLoginRes;
import com.blending.mailingservice.user.dto.UserSignUpDto;
import com.blending.mailingservice.user.entity.User;
import com.blending.mailingservice.user.repository.UserRepository;
import com.blending.mailingservice.util.exception.CustomException;
import com.blending.mailingservice.util.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserSignUpDto signup(UserSignUpDto userSignUpDto) {

        // 이미 존재하는 아이디인가?
        if(userRepository.existsById(userSignUpDto.getId())) {
            throw new CustomException(ErrorCode.ID_EXIST);
        }

        // 비밀번호1 칸이 비었는가?
        if(userSignUpDto.getPw() == null
                || userSignUpDto.getPw().isEmpty()
                || userSignUpDto.getPw().isBlank()) {
            throw new CustomException(ErrorCode.PW_EMPTY);
        }

        // 비밀번호2 칸이 비었는가?
        if(userSignUpDto.getPw2() == null
                || userSignUpDto.getPw2().isEmpty()
                || userSignUpDto.getPw2().isBlank()) {
            throw new CustomException(ErrorCode.PW2_EMPTY);
        }

        // 비밀번호1과 비밀번호2가 일치하는가?
        if(!userSignUpDto.getPw().equals(userSignUpDto.getPw2())) {
            throw new CustomException(ErrorCode.PW_MISMATCH);
        }

        // 회원가입
        User newUser = User.builder()
                .id(userSignUpDto.getId())
                .password(userSignUpDto.getPw())
                .name(userSignUpDto.getName())
                .build();

        userRepository.save(newUser);

        return UserSignUpDto.builder()
                .id(newUser.getId())
                .pw(newUser.getPassword())
                .name(userSignUpDto.getName())
                .build().passwordMasked();

    }

    @Override
    public UserLoginRes login(UserLoginReq userLoginReq) {

        // 존재하는 아이디인가?
        if (!userRepository.existsById(userLoginReq.getId())) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        // 비밀번호가 일치하는가?
        if(!userLoginReq.getPw().equals(userRepository.findById(userLoginReq.getId()).get().getPassword())) {
            throw new CustomException(ErrorCode.PW_MISMATCH);
        }

        // 로그인
        return UserLoginRes.builder()
                .id(userLoginReq.getId())
                .name(userRepository.findById(userLoginReq.getId()).get().getName()).build();

    }

}
