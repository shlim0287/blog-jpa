package com.estsoft.blogjpa.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ReplyResponseShow {
    private Long commentId;

    private String body;

    private LocalDateTime createdAt;

    @Builder
    public ReplyResponseShow(Long commentId,String body,LocalDateTime createdAt){
        this.commentId=commentId;
        this.body=body;
        this.createdAt=createdAt;
    }
}
