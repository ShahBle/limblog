package com.sparta.limblog.entity;

import com.sparta.limblog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


    //비밀번호
//    @Column(nullable = false)
//    private String password;



//    @Column(nullable = false)
//    private Long userId;

    @Builder
    public Blog(String title, String contents, User user) {
        this.title = title;
        this.contents = contents;
        this.user = user;
//        this.username = signupRequestDto.getUsername();
//        this.author = requestDto.getAuthor();
//        this.password = requestDto.getPassword();
//        this.userId = userId;
    }


    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
//        this.author = requestDto.getAuthor();
    }

    public boolean isEqualId(Long id) {
        return this.user.getId().equals(id);
    }

}
