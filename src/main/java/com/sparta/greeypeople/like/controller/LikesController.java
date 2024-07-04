package com.sparta.greeypeople.like.controller;

import com.sparta.greeypeople.auth.security.UserDetailsImpl;
import com.sparta.greeypeople.common.DataCommonResponse;
import com.sparta.greeypeople.like.dto.MenuLikesResponseDto;
import com.sparta.greeypeople.like.dto.ReviewLikesResponseDto;
import com.sparta.greeypeople.like.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @GetMapping("/likedReviews")
    public ResponseEntity<DataCommonResponse<Page<ReviewLikesResponseDto>>>getLikedReviews(
        @AuthenticationPrincipal UserDetailsImpl userDetails,
        @RequestParam int size,
        @RequestParam int page
    ){
        Page<ReviewLikesResponseDto> likedReviewsPage = likesService.getLikedReviews(userDetails, page-1, size);
        DataCommonResponse<Page<ReviewLikesResponseDto>> response = new DataCommonResponse<>(200,
            "좋아요한 댓글 목록 조회 성공", likedReviewsPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/likedMenus")
    public ResponseEntity<DataCommonResponse<Page<MenuLikesResponseDto>>>getLikedMenus(
        @AuthenticationPrincipal UserDetailsImpl userDetails,
        @RequestParam int page,
        @RequestParam int size
    ){
        Page<MenuLikesResponseDto> likedMenusPage = likesService.getLikedMenus(userDetails, page-1, size);
        DataCommonResponse<Page<MenuLikesResponseDto>> response = new DataCommonResponse<>(200,
            "좋아요한 메뉴 목록 조회 성공", likedMenusPage);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
