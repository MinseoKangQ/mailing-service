package com.blending.mailingservice.user.controller;

import com.blending.mailingservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mailing-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 Controller
    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("pw") String pw) {

        String result = userService.signUp(id, name, pw);
        System.out.println(result);
        return "signup_success";
    }

    // 로그인 Controller
    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("pw") String pw) {
        String result = userService.login(id, pw);
        System.out.println(result);
        if(result.equals("login success")) return "login_success";
        else if(result.equals("pw is incorrect")) return "login_fail_by_pw";
        else return "login_fail_by_id";
    }

}
