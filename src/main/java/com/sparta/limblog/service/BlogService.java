package com.sparta.limblog.service;

import com.sparta.limblog.dto.BlogRequestDto;
import com.sparta.limblog.dto.PostPasswordDto;
import com.sparta.limblog.dto.PostResponseDto;
import com.sparta.limblog.entity.Blog;
import com.sparta.limblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;

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
    public List<Blog> showAll() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public String  update(Long id, BlogRequestDto requestDto,String password) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        ); if(password.equals(blog.getPassword())){
            blog.update(requestDto);
            return "게시글이 수정되었습니다";

        }
        return "비밀번호가 틀렸습니다";
    }

    @Transactional
    public String deletePost(Long id,String password ) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        if(Objects.equals(blog.getPassword(),password)){
            blogRepository.deleteById(id);
            return "게시글이 삭제되었습니다";
        }
        return "비밀번호가 틀렸습니다";
//        if(password.equals(blog.getPassword())){
//            blogRepository.deleteById(id);
//            return "게시글이 삭제되었습니다";
//
//        }
//        return "비밀번호가 틀렸습니다";
//        blogRepository.deleteById(id);
//        return "게시글이 삭제되었습니다";
    }

    @Transactional
    public PostResponseDto findById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시물이 없습니다" + id)
        );
        return new PostResponseDto(blog);
    }

    public boolean comparePassword(Long id, PostPasswordDto postPasswordDto){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당아이디가 존재 x")
        );
        return Objects.equals(blog.getPassword(), postPasswordDto.getPassword());
    }
}
