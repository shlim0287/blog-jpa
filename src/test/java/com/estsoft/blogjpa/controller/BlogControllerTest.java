package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.dto.AddArticleRequest;
import com.estsoft.blogjpa.repository.BlogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext ac;

    @Autowired
    BlogRepository blogRepository;
    
    @Autowired
    ObjectMapper objectMapper;
    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ac).build();
    }
    @Test
    void addArticle() throws Exception {
        //given // 저장하려는 블로그 정보
        AddArticleRequest request=new AddArticleRequest("제목","내용");
        String json = objectMapper.writeValueAsString(request);
        //when POST /api/articles
        ResultActions perform = mockMvc.perform(post("/api/articles")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then 검증 및 상태코드 201인지 판단
        perform.andExpect(status().isCreated());
        
        // 저장 여부 확인
        perform.andExpect(status().isCreated()).andExpect(jsonPath("title")
                .value(request.getTitle()))
                .andExpect(jsonPath("content").value(request.getContent()));
    }

    @Test
    void findAllArticles() throws Exception{
        //given
        List<Article> list=new ArrayList<>();
        Article article1 = new Article("제목1", "내용1");
        Article article2 = new Article("제목2", "내용2");
        list.add(article1);
        list.add(article2);

        blogRepository.saveAll(list);

        //when

        ResultActions resultActions = mockMvc.perform(get("/api/articles"));


        //then
        resultActions.andExpect(status().isOk());

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(list.get(0).getTitle()))
                .andExpect(jsonPath("$[0].content").value(list.get(0).getContent()));
    }

    @Test
    void deleteById() throws Exception {
        //given
        Article saveArticle = blogRepository.save(new Article("title", "content"));
        Long id = saveArticle.getId();
        //when
        ResultActions resultActions = mockMvc.perform(delete("/api/articles/{id}", id));
        //then

        resultActions.andExpect(status().isOk());
    }

    @Test
    void updateTitle() throws Exception {
        //given
        Article saveedArticle = blogRepository.save(new Article("title3", "content3"));
        Long id = saveedArticle.getId();
        AddArticleRequest request=new AddArticleRequest("updateTitle","updateContent");
        String json = objectMapper.writeValueAsString(request);
        //when
        ResultActions resultActions = mockMvc.perform(put("/api/articles/{id}", id)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE));
        //then
        resultActions.andExpect(status().isOk());
    }
}