package com.example.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    //블로그 글 생성
    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    //블로그 글 수정
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
