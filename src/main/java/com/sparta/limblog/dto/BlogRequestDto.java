package com.sparta.limblog.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String title;
    private String contents;
    private String author;
    private int password;
}
