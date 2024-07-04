package com.sparta.greeypeople.profile.repository.likes.Review;

import com.sparta.greeypeople.like.entity.ReviewLikes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesReviewRepository extends JpaRepository<ReviewLikes, Long>,
    LikesReviewRepositoryQuery {

}
