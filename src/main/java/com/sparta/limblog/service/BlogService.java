package com.sparta.limblog.service;

import com.sparta.limblog.dto.BlogRequestDto;
import com.sparta.limblog.dto.PostResponseDto;
import com.sparta.limblog.entity.Blog;
import com.sparta.limblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Blog createWritePost(BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);
        return blog;
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> showAll() {
        List<Blog> blogList = blogRepository.findAllByOrderByModifiedAtDesc();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for(Blog blog: blogList){
            PostResponseDto postResponseDto = new PostResponseDto(blog);
            postResponseDtoList.add(postResponseDto);
        }
        return postResponseDtoList;
    }

    @Transactional
    public PostResponseDto findById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물이 없습니다" + id)
        );
        return new PostResponseDto(blog);
    }

    @Transactional
    public String  update(Long id, BlogRequestDto requestDto,String password) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        ); if(password.equals(blog.getPassword())){
            blog.update(requestDto);
            return "ID:" + String.valueOf(id)+"의 게시글이 수정되었습니다";
        }
        return "비밀번호가 틀렸습니다";
    }

    // ====== 삭제기능에서 true, false값을 출력할려면 밑 boolean문 사용하기===================================
    // ====== 명세서에선 "success": true를 보여주기 위해 Sting 사용(삭제된지 안된지도 구분하기 쉽게 메세지 작성=====
    @Transactional
    public String deletePost(Long id, String password){
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        String msg;
        if(password.equals(blog.getPassword())){
            blogRepository.deleteById(id);
            return msg = "삭제 완료 (pwd success: true)";
        }
        return msg = "비밀번호가 틀렸습니다 (pwd success: false)";
    }
    //====== boolean deletePost문=================
//    @Transactional
//    public boolean deletePost(Long id, String password){
//        Blog blog = blogRepository.findById(id).orElseThrow(
//                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
//        );
//        String msg;
//        if(password.equals(blog.getPassword())){
//            blogRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }


}
