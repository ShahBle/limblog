package com.sparta.limblog.controller;

import com.sparta.limblog.dto.BlogRequestDto;
import com.sparta.limblog.dto.PostResponseDto;
import com.sparta.limblog.service.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    //게시글 작성
    @PostMapping("/api/post")
    public ResponseEntity<PostResponseDto> createWritePost(@Validated @RequestBody BlogRequestDto requestDto
            , HttpServletRequest request) {
        return blogService.createWritePost(requestDto, request);
    }
//    @PostMapping("/api/post")
//    public Blog createWritePost(@RequestBody BlogRequestDto requestDto ){
//        return blogService.createWritePost(requestDto);
//    }

    //게시글 전체 조회
    @GetMapping("/api/posts")
    public List<PostResponseDto> showAll() {
        return blogService.showAll();
    }

    //선택 게시글 조회
    @GetMapping("/api/post{id}")
    public PostResponseDto showPost(@PathVariable Long id) {
        return blogService.findById(id);
    }

    //게시글 수정
    @PutMapping("/api/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody @Validated BlogRequestDto requestDto
            , HttpServletRequest request) {
        return blogService.update(id, requestDto, request);
    }

    //게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public PostResponseDto  deletePost(@PathVariable Long id, HttpServletRequest request){
        return blogService.deletePost(id,request);
    }

}
