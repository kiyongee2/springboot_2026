package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가
    public Article save(AddArticleRequest request){
        Article article = request.toEnity();
        return blogRepository.save(article);
    }

    //블로그 글 목록
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
