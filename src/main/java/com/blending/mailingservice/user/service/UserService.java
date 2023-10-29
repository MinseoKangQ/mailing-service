package com.blending.mailingservice.user.service;

import com.blending.mailingservice.user.dto.UserLoginDto;
import com.blending.mailingservice.user.dto.UserSignUpDto;

public interface UserService {
    UserSignUpDto signup(UserSignUpDto userSignUpDto);
    UserLoginDto login(UserLoginDto userLoginDto);
}
