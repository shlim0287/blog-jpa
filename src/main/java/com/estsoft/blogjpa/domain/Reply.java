package com.estsoft.blogjpa.domain;

import com.estsoft.blogjpa.domain.dto.ReplyDTO;
import com.estsoft.blogjpa.domain.dto.ReplyResponse;
import com.estsoft.blogjpa.domain.dto.ReplyResponseShow;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;

    @Column(name="article_id")
    private Long articleId;

    @Column(name = "body",nullable = false)
    private String body;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Builder
    public Reply(Long articleId,String body){
        this.articleId=articleId;
        this.body=body;
    }

    public ReplyResponse toResponseComment(){
        return new ReplyResponse().builder()
                .body(body)
                .build();
    }
    public ReplyResponseShow toResponseCommentShow(){
        return new ReplyResponseShow().builder()
                .commentId(id)
                .body(body)
                .createdAt(created_at)
                .build();
    }


}
