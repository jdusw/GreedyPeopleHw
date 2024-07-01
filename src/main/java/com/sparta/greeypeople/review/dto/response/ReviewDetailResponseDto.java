package com.sparta.greeypeople.review.dto.response;

import com.sparta.greeypeople.review.entity.Review;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ReviewDetailResponseDto {
    private final String content;
    private final Long  reviewLikes;
    private final LocalDateTime updateAt;

    public ReviewDetailResponseDto(Review review) {
        this.content = review.getContent();
        this.reviewLikes = review.getReviewLikes();
        this.updateAt = review.getModifiedAt();
    }
}
