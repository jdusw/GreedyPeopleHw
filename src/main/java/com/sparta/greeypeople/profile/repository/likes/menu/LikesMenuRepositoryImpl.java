package com.sparta.greeypeople.profile.repository.likes.menu;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.greeypeople.like.entity.QMenuLikes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikesMenuRepositoryImpl implements LikesMenuRepositoryQuery {
    private final JPAQueryFactory jpaQueryFactory;

    public Long getMenuCount(Long userId){

        QMenuLikes qmenuLikes = QMenuLikes.menuLikes;

         return jpaQueryFactory
            .select(qmenuLikes.count())
            .from(qmenuLikes)
             .where(
                 qmenuLikes.user.id.eq(userId)
             )
             .fetchOne();
    }

}
