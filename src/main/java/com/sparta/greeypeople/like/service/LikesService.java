package com.sparta.greeypeople.like.service;

import com.sparta.greeypeople.auth.security.UserDetailsImpl;
import com.sparta.greeypeople.like.dto.MenuLikesResponseDto;
import com.sparta.greeypeople.like.dto.ReviewLikesResponseDto;
import com.sparta.greeypeople.like.entity.MenuLikes;
import com.sparta.greeypeople.like.entity.ReviewLikes;
import com.sparta.greeypeople.like.repository.MenuLikes.MenuLikesRepository;
import com.sparta.greeypeople.like.repository.ReviewLikes.ReviewLikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final MenuLikesRepository menuLikesRepository;
    private final ReviewLikesRepository reviewLikesRepository;

    public Page<ReviewLikesResponseDto> getLikedReviews(UserDetailsImpl userDetails, int page, int size) {
            PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "userId"));
            Page<ReviewLikes> reviewPage = reviewLikesRepository.getLikedReviews(userDetails.getUser().getId(), pageRequest);
            return reviewPage
                .map(m-> ReviewLikesResponseDto.builder()
                    .content(m.getReview().getContent())
                    .reviewLikes(m.getReview().getReviewLikes())
                    .updateAt(m.getReview().getModifiedAt())
                    .build());
        }

    public Page<MenuLikesResponseDto> getLikedMenus(UserDetailsImpl userDetails, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "userId"));
        Page<MenuLikes> menuLikesPage = menuLikesRepository.getLikedMenus(userDetails.getUser().getId(), pageRequest);

        return menuLikesPage
            .map(m -> MenuLikesResponseDto.builder()
                .storeId(m.getMenu().getStore().getId())
                .menuName(m.getMenu().getMenuName())
                .menuLikes(m.getMenu().getMenuLikes())
                .price(m.getMenu().getPrice())
                .build());
    }
}
