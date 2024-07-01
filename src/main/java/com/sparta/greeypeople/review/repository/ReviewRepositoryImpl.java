package com.sparta.greeypeople.review.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.greeypeople.review.entity.QReview;
import com.sparta.greeypeople.review.entity.Review;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryQuery{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> findAllByStoreId(Long storeId){

        QReview review = QReview.review;

        return jpaQueryFactory.selectFrom(review)
            .where(review.store.id.eq(storeId))
            .fetch();
    }
}
