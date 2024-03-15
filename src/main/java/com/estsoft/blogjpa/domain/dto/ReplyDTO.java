package com.estsoft.blogjpa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReplyDTO {
    private Long id;
    private String body;
    private String createdAt;
}
