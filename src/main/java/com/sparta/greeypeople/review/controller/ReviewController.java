package com.sparta.greeypeople.review.controller;

import com.sparta.greeypeople.auth.security.UserDetailsImpl;
import com.sparta.greeypeople.common.DataCommonResponse;
import com.sparta.greeypeople.common.StatusCommonResponse;
import com.sparta.greeypeople.review.dto.request.ReviewRequestDto;
import com.sparta.greeypeople.review.dto.response.ReviewDetailResponseDto;
import com.sparta.greeypeople.review.dto.response.ReviewsResponseDto;
import com.sparta.greeypeople.review.service.ReviewService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * 리뷰 등록 기능
     *
     * @param storeId          : 리뷰 등록 할 가게의 Id
     * @param reviewRequestDto : 등록할 리뷰 정보
     * @return : 등록된 리뷰 정보
     */
    @PostMapping("/stores/{storeId}/review")
    public ResponseEntity<DataCommonResponse<ReviewsResponseDto>> createReview(
        @PathVariable Long storeId,
        @Valid @RequestBody ReviewRequestDto reviewRequestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        ReviewsResponseDto responseDto = reviewService.createReview(reviewRequestDto, storeId,
            userDetails.getUser());
        DataCommonResponse<ReviewsResponseDto> response = new DataCommonResponse<>(201, "리뷰 등록 성공",
            responseDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * 리뷰 단건 조회 기능
     *
     * @param storeId  : 리뷰 등록된 가게의 Id
     * @param reviewId : 등록된 리뷰 정보 Id
     * @return : 등록된 리뷰 정보
     */
    @GetMapping("/stores/{storeId}/reviews/{reviewId}")
    public ResponseEntity<DataCommonResponse<ReviewDetailResponseDto>> getReview(
        @PathVariable Long storeId,
        @PathVariable Long reviewId
    ) {
        ReviewDetailResponseDto review = reviewService.getReview(storeId, reviewId);
        DataCommonResponse<ReviewDetailResponseDto> response = new DataCommonResponse<>(200,
            "리뷰 조회 단건 성공", review);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 리뷰 전체 조회 기능
     *
     * @param storeId : 리뷰 등록된 가게의 Id
     * @return : 등록된 리뷰 정보
     */
    @GetMapping("/stores/{storeId}/reviews")
    public ResponseEntity<DataCommonResponse<List<ReviewsResponseDto>>> getAllReviews(
        @PathVariable Long storeId) {
        List<ReviewsResponseDto> reviews = reviewService.getAllReviews(storeId);
        DataCommonResponse<List<ReviewsResponseDto>> response = new DataCommonResponse<>(200,
            "리뷰 조회 전체 성공", reviews);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 리뷰 수정 기능
     *
     * @param storeId          : 리뷰 등록된 가게의 Id
     * @param reviewId         : 등록된 리뷰 정보 Id
     * @param reviewRequestDto : 수정할 리뷰 정보
     * @return : 등록된 리뷰 정보
     */
    @PutMapping("/stores/{storeId}/reviews/{reviewId}")
    public ResponseEntity<DataCommonResponse<ReviewsResponseDto>> updateReview(
        @PathVariable Long storeId,
        @PathVariable Long reviewId,
        @Valid @RequestBody ReviewRequestDto reviewRequestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        ReviewsResponseDto responseDto = reviewService.updateReview(storeId, reviewId,
            reviewRequestDto, userDetails.getUser());
        DataCommonResponse<ReviewsResponseDto> response = new DataCommonResponse<>(200, "리뷰 수정 성공",
            responseDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 리뷰 수정 기능
     *
     * @param storeId  : 리뷰 등록된 가게의 Id
     * @param reviewId : 삭제할 리뷰 정보 Id
     * @return : 삭제 성공 메세지
     */
    @DeleteMapping("/stores/{storeId}/reviews/{reviewId}")
    public ResponseEntity<StatusCommonResponse> deleteReview(
        @PathVariable Long storeId,
        @PathVariable Long reviewId,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        reviewService.deleteReview(storeId, reviewId, userDetails.getUser());
        StatusCommonResponse response = new StatusCommonResponse(200, "리뷰 삭제 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
