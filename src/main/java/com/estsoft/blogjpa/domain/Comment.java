package com.estsoft.blogjpa.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    private Long id;
    private Long article_id;
    private String title;
    private LocalDateTime created
}
