package com.blending.mailingservice.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginDto {
    private String id;
    private String pw;

    public UserLoginDto passwordMasked() {
        return new UserLoginDtoBuilder()
                .id(this.id)
                .pw(this.pw)
                .build();
    }

}
