package com.sparta.limblog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequestDto extends SignupRequestDto {
    private String title;
    private String contents;
    private String username;
//    private String author;
//    private String password;
}
