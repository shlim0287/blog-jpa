package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.domain.dto.AddArticleRequest;
import com.estsoft.blogjpa.domain.dto.UpdateArticleRequest;
import com.estsoft.blogjpa.external.ExampleAPIClient;
import com.estsoft.blogjpa.repository.BlogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {

    private final BlogRepository blogRepository;
    private final ExampleAPIClient apiClient;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Optional<Article> findById(Long id){
        return blogRepository.findById(id);
    }

    public void deleteById(Long id){
        blogRepository.deleteById(id);
    }
    @Transactional
    public Article update(Long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found"+id));
        article.update(request.getTitle(),request.getContent());
        return article;
    }
    @Transactional
    public Article updateTitle(Long id,AddArticleRequest request){
        Article article = findById(id).orElseThrow(()->new IllegalArgumentException("not found"+id));
        blogRepository.updateTitle(id,request.getTitle());
        return article;
    }

    public void deleteAll(){
        blogRepository.deleteAll();
    }

    public List<Article> saveBulkArticles(){
        List<Article> articles = parsedArticles();
        return blogRepository.saveAllAndFlush(articles);
    }

    public List<Article> saveBulkArticlesByWebclient(){
        List<Article> articles = parsedArticlesByWebClient();
        return blogRepository.saveAllAndFlush(articles);
    }

    private List<Article> parsedArticlesByWebClient(){
        String url="https://jsonplaceholder.typicode.com/posts";
        String responseJson = apiClient.fetchDataFromApi2(url);

        ObjectMapper objectMapper=new ObjectMapper();
        List<LinkedHashMap<String,String>> jsonMapList=new ArrayList<>();
        try {
            jsonMapList = objectMapper.readValue(responseJson, List.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse json:",e.getMessage());
        }
        return jsonMapList.stream()
                .map(hashMap->new Article(hashMap.get("title"),hashMap.get("body")))
                .toList();
    }
    
    private List<Article> parsedArticles(){
        String url="https://jsonplaceholder.typicode.com/posts";
        String responseJson = apiClient.fetchDataFromApi(url);

        ObjectMapper objectMapper=new ObjectMapper();
        List<LinkedHashMap<String,String>> jsonMapList=new ArrayList<>();

        try{
            jsonMapList = objectMapper.readValue(responseJson, List.class);
        }catch (JsonProcessingException e){
            log.error("Failed to parse json:",e.getMessage());
        }

        return jsonMapList.stream()
                .map(hashMap->new Article(hashMap.get("title"),hashMap.get("body")))
                .toList();
    }
}
