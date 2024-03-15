package com.estsoft.blogjpa.domain.dto;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class ArticleWithReplies {
    private Article article;
    private List<Reply> replies;
}
