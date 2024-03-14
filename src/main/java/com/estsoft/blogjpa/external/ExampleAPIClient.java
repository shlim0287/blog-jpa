package com.estsoft.blogjpa.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ExampleAPIClient {
    public String fetchDataFromApi(String apiUrl){
        //RestTemplate-> HTTP 통신 도구
        // 외부 도메인으로부터 데이터를 가져오거나 전송할 때 사용
        RestTemplate restTemplate=new RestTemplate();

        // 지정된 url에 GET 요청을 보내고 해당 요청에 대한 응답을 받음
        // String.class를 통해 응답 본문을 문자열로 처리

        ResponseEntity<String> responseEntity= restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }else{
            log.error("Failed to fetch data from API. Status code:"+responseEntity.getStatusCodeValue());
            return null;
        }
    }

    public String fetchDataFromApi2(String apiUrl){
        WebClient webClient = WebClient.create(apiUrl);

        Mono<String> responseMono = webClient.get()
                .retrieve()
                .bodyToMono(String.class);

        String responseBody = responseMono.block();

        if(responseBody!=null){
            return responseBody;
        }else{
            log.error("Failed to fetch data from API.");
            return null;
        }
    }
}
