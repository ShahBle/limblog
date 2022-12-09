package com.sparta.limblog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogRequestDto {
    private String title;
    private String contents;
    private String author;
    private String password;
}
