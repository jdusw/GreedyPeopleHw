package com.sparta.greeypeople.like.repository.ReviewLikes;

import com.sparta.greeypeople.like.entity.ReviewLikes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ReviewLikesRepositoryQuery {
    Page<ReviewLikes> getLikedReviews(Long userId, PageRequest pageRequest);
}
