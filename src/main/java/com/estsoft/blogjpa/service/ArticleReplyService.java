package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.Reply;
import com.estsoft.blogjpa.domain.dto.AddReplyRequest;
import com.estsoft.blogjpa.domain.dto.ArticleWithReplies;
import com.estsoft.blogjpa.repository.BlogRepository;
import com.estsoft.blogjpa.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleReplyService {

    private final BlogRepository blogRepository;
    private final ReplyRepository replyRepository;


    public Reply saveReply(Long articleId,AddReplyRequest request){
        Reply reply = request.toEntity(articleId);
        return replyRepository.save(reply);
    }

    public Reply getReply(Long articleId,Long commentId){
        return replyRepository.findByArticleIdAndId(articleId,commentId);
    }

    public ArticleWithReplies getArticleWithComments(Long id) {
        Article article = blogRepository.findById(id).orElse(null);
        if (article != null) {
            List<Reply> replies = replyRepository.findByArticleId(id);
            return new ArticleWithReplies(article, replies);
        }
        return null;
    }
}
