package com.sparta.limblog.entity;

import com.sparta.limblog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Blog extends Timestamped{
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //제목
    @Column(nullable = false)
    private String title;
    //작성 내용
    @Column(nullable = false)
    private String contents;
    //작성자명
    @Column(nullable = false)
    private String author;
    //비밀번호
    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
//    private Long userId;

    public Blog(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
//        this.userId = userId;
    }


//    public Blog(BlogRequestDto requestDto) {
//        this.title = requestDto.getTitle();
//        this.contents = requestDto.getContents();
//        this.author = requestDto.getAuthor();
//        this.password = requestDto.getPassword();
//    }

    public void update(BlogRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
    }



}
