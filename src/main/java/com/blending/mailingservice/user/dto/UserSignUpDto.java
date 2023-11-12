package com.blending.mailingservice.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSignUpDto {
    private String id;
    private String name;
    private String pw;
    private String pw2;

    public UserSignUpDto passwordMasked() {
        return new UserSignUpDtoBuilder()
                .id(this.id)
                .name(this.name)
                .pw("****")
                .pw2("****")
                .build();
    }

}
