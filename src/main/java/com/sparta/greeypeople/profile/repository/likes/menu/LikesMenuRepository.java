package com.sparta.greeypeople.profile.repository.likes.menu;

import com.sparta.greeypeople.like.entity.MenuLikes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesMenuRepository extends JpaRepository<MenuLikes,Long>,
    LikesMenuRepositoryQuery {
}
