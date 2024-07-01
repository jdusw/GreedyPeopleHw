package com.sparta.greeypeople.review.repository;

import com.sparta.greeypeople.review.entity.Review;
import java.util.List;

public interface ReviewRepositoryQuery {
    List<Review> findAllByStoreId(Long storeId);
}
