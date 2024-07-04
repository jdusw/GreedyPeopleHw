package com.sparta.greeypeople.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MenuLikesResponseDto {
    private Long storeId;
    private String menuName;
    private Long menuLikes;
    private int price;
}
