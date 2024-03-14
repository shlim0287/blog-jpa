package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.dto.AddArticleRequest;
import com.estsoft.blogjpa.domain.dto.ArticleResponse;
import com.estsoft.blogjpa.domain.dto.UpdateArticleRequest;
import com.estsoft.blogjpa.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/articles")
public class BlogController {
    private final BlogService blogService;

    @PostMapping
    @ResponseBody // json 타입이 넘어온다.
    public ResponseEntity<ArticleResponse> addArticle(@RequestBody AddArticleRequest request) {

        Article article = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.toResponse());
    }

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<List<ArticleResponse>> showArticle(){
//        List<Article> articles = blogService.findAll();
//        List<ArticleResponse> responseList=articles.stream()
//                .map(ArticleResponse::new)
//                .toList();
//        return ResponseEntity.ok().body(responseList);
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> findById(@PathVariable Long id){
        Article article = blogService.findById(id).orElseThrow(()->new IllegalArgumentException("잘못된 입력 값"));
        return ResponseEntity.ok().body(article.toResponse());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        blogService.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request){
//        Article article = blogService.update(id, request);
//        return ResponseEntity.status(HttpStatus.OK).body(article);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateTitle(@PathVariable Long id,@RequestBody AddArticleRequest request){
        Article article = blogService.updateTitle(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

}
