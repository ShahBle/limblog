package com.sparta.limblog.dto;

import com.sparta.limblog.entity.Blog;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Blog entity){
        this.title = entity.getTitle();
        this.content = entity.getContents();
        this.author = entity.getAuthor();
    }
}
