package com.estsoft.blogjpa.domain.dto;

import com.estsoft.blogjpa.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReplyRequest {
    private String body;

    public Reply toEntity(Long articleId){
        return Reply.builder()
                .articleId(articleId)
                .body(body)
                .build();
    }
}
