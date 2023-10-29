package com.blending.mailingservice.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSignUpDto {
    private String id;
    private String pw;
    private String pw2;

    public UserSignUpDto passwordMasked() {
        return new UserSignUpDtoBuilder()
                .id(this.id)
                .pw(this.pw)
                .pw2(this.pw2)
                .build();
    }

}
