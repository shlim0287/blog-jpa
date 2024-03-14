package com.estsoft.blogjpa.domain.dto;

import com.estsoft.blogjpa.domain.Article;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor

public class ArticleResponse {
    private String title;
    private String content;

    @Builder
    public ArticleResponse(String title,String content){
        this.title=title;
        this.content=content;
    }

    public ArticleResponse(Article article){
        title=article.getTitle();
        content=article.getContent();
    }
}
