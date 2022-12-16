package com.sparta.limblog.controller;

import com.sparta.limblog.dto.LoginRequestDto;
import com.sparta.limblog.dto.SignupRequestDto;
import com.sparta.limblog.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

//    @GetMapping("/signup")
//    public ModelAndView signupPage() {
//        return new ModelAndView("signup");
//    }

//    @GetMapping("/login")
//    public ModelAndView loginPage() {
//        return new ModelAndView("login");
//    }

    //회원가입
    @PostMapping("/signup")

    public String signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
//        return "회원가입 성공";
//        return "redirect:/api/user/login";
    }
//    //로그인
//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequestDto loginRequestDto) {
//        userService.login(loginRequestDto);
//        return "로그인성공";
//    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }

}
