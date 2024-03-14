package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JsonParseTestController {
    private final BlogService blogService;

    @ResponseBody
    @GetMapping("/api/test1")
    public List<Article> test(){
        return blogService.saveBulkArticles();
    }

    @ResponseBody
    @GetMapping("/api/test2")
    public List<Article> test2(){
        return blogService.saveBulkArticlesByWebclient();
    }


    @GetMapping("/deleteAll")
    @ResponseBody
    public String deleteAllData(){
        blogService.deleteAll();
        return "다 지움";
    }
}
