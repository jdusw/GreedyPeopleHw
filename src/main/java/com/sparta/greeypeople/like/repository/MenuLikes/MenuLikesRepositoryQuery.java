package com.sparta.greeypeople.like.repository.MenuLikes;

import com.sparta.greeypeople.like.entity.MenuLikes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface MenuLikesRepositoryQuery {
    Page<MenuLikes> getLikedMenus(Long userId, PageRequest pageRequest);
}
