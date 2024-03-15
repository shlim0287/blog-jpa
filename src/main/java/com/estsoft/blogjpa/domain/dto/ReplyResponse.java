package com.estsoft.blogjpa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
public class ReplyResponse {
    private String body;
    @Builder
    public ReplyResponse(String body){
        this.body=body;
    }
}
