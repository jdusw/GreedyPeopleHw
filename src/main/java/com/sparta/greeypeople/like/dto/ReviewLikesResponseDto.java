package com.sparta.greeypeople.like.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewLikesResponseDto {

    private String content;
    private Long  reviewLikes;
    private LocalDateTime updateAt;
}
