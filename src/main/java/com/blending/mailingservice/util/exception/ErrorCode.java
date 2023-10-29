package com.blending.mailingservice.util.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // USER 관련
    ID_EXIST(HttpStatus.CONFLICT, "이미 존재하는 아이디입니다."),
    PW_EMPTY(HttpStatus.BAD_REQUEST, "비밀번호가 비었습니다."),
    PW2_EMPTY(HttpStatus.BAD_REQUEST, "비밀번호가 비었습니다."),
    PW_MISMATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "등록되지 않은 아이디입니다."),
    USER_PW_MISMATCH(HttpStatus.UNAUTHORIZED, "해당 아이디의 비밀번호가 일치하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
