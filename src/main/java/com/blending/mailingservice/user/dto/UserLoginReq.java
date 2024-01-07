package com.blending.mailingservice.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginReq {
    private String id;
    private String pw;
}
