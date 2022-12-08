package com.sparta.limblog.controller;

import com.sparta.limblog.dto.BlogRequestDto;
import com.sparta.limblog.dto.PostPasswordDto;
import com.sparta.limblog.dto.PostResponseDto;
import com.sparta.limblog.entity.Blog;
import com.sparta.limblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/api/post")
    public Blog createWritePost(@RequestBody BlogRequestDto requestDto ){
        return blogService.createWritePost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Blog> showAll(){
        return blogService.showAll();
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto showPost(@PathVariable Long id){
        return blogService.findById(id);
    }

    @PutMapping("/api/post/{id}")
    public String updatePost(@PathVariable Long id, @RequestBody BlogRequestDto requestDto
                      ,@RequestParam("password") String password){
        return blogService.update(id,requestDto,password);
    }

    @DeleteMapping("/api/post/{id}")
    public String deletePost(@RequestParam("id") Long id, @RequestParam("password") String password){
        blogService.deletePost(id,password);
        return String.valueOf(id) + "번 글이 삭제되었습니다";
    }

    @PostMapping("/api/posts/{id}")
    public boolean comparePassword(@PathVariable Long id, @RequestBody PostPasswordDto postPasswordDto){
        return blogService.comparePassword(id, postPasswordDto);
    }

}
