package com.sparta.greeypeople.profile.repository.likes.Review;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.greeypeople.like.entity.QReviewLikes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikesReviewRepositoryImpl implements LikesReviewRepositoryQuery {
    private final JPAQueryFactory jpaQueryFactory;

    public Long getReviewCount(Long userId){

        QReviewLikes qReviewLikes = QReviewLikes.reviewLikes;

        return jpaQueryFactory
            .select(qReviewLikes.count())
            .from(qReviewLikes)
            .where(
                qReviewLikes.user.id.eq(userId)
            )
            .fetchOne();
    }
}
