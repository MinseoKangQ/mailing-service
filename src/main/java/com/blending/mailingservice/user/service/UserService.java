package com.blending.mailingservice.user.service;

import com.blending.mailingservice.user.dto.UserLoginReq;
import com.blending.mailingservice.user.dto.UserLoginRes;
import com.blending.mailingservice.user.dto.UserSignUpDto;

public interface UserService {
    UserSignUpDto signup(UserSignUpDto userSignUpDto);
    UserLoginRes login(UserLoginReq userLoginReq);
}
