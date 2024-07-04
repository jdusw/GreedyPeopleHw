package com.sparta.greeypeople.like.repository.ReviewLikes;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.greeypeople.like.entity.QReviewLikes;
import com.sparta.greeypeople.like.entity.ReviewLikes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewLikesRepositoryImpl implements ReviewLikesRepositoryQuery{

    private final JPAQueryFactory jpaQueryFactory;

    public Page<ReviewLikes> getLikedReviews(Long userId, PageRequest pageRequest){
        QReviewLikes reviewLikes = QReviewLikes.reviewLikes;

        List<ReviewLikes> results = jpaQueryFactory.selectFrom(reviewLikes)
            .where(reviewLikes.user.id.eq(userId))
            .orderBy(reviewLikes.id.desc())
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize())
            .fetch();

        long total = jpaQueryFactory.selectFrom(reviewLikes)
            .where(reviewLikes.user.id.eq(userId))
            .fetch().size();

        return new PageImpl<>(results, pageRequest, total);
    }
}
