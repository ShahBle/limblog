package com.sparta.limblog.dto;

import com.sparta.limblog.entity.Blog;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDto {
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;;
    private String title;
    private String content;
    private String author;



    public PostResponseDto(Blog entity){
        this.createAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
        this.title = entity.getTitle();
        this.content = entity.getContents();
        this.author = entity.getAuthor();
    }
}
