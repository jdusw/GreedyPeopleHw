package com.sparta.greeypeople.like.repository.MenuLikes;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.greeypeople.like.entity.MenuLikes;
import com.sparta.greeypeople.like.entity.QMenuLikes;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MenuLikesRepositoryImpl implements MenuLikesRepositoryQuery{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<MenuLikes> getLikedMenus(Long userId, PageRequest pageRequest){

        QMenuLikes menuLikes = QMenuLikes.menuLikes;

        List<MenuLikes> results = jpaQueryFactory.selectFrom(menuLikes)
            .where(menuLikes.user.id.eq(userId))
            .orderBy(menuLikes.id.desc())
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize())
            .fetch();

        long total = jpaQueryFactory.selectFrom(menuLikes)
            .where(menuLikes.user.id.eq(userId))
            .fetch().size();

        return new PageImpl<>(results, pageRequest, total);
    }
}
