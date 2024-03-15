package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Reply;
import com.estsoft.blogjpa.domain.dto.*;
import com.estsoft.blogjpa.service.ArticleReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final ArticleReplyService articleReplyService;

    @PostMapping("/{articleId}")
    @ResponseBody
    public ResponseEntity<ReplyResponse> addReply(@PathVariable Long articleId,@RequestBody AddReplyRequest request){
        Reply reply = articleReplyService.saveReply(articleId,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(reply.toResponseComment());
    }

    @GetMapping("/{articleId}/{commnetId}")
    @ResponseBody
    public ResponseEntity<ReplyResponseShow> getReply(@PathVariable Long articleId, @PathVariable Long commnetId){
        Reply reply = articleReplyService.getReply(articleId, commnetId);
        return ResponseEntity.ok().body(reply.toResponseCommentShow());
    }

    @GetMapping("/{articleId}")
    @ResponseBody
    public ResponseEntity<ArticleWithReplies> getRepliesByArticleId(@PathVariable Long articleId){
        ArticleWithReplies articleWithComments = articleReplyService.getArticleWithComments(articleId);
        return ResponseEntity.ok().body(articleWithComments);
    }

}
