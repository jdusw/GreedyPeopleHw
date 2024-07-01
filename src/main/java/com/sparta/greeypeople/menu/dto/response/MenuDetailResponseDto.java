package com.sparta.greeypeople.menu.dto.response;

import com.sparta.greeypeople.menu.entity.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuDetailResponseDto {
    private Long storeId;
    private String menuName;
    private Long menuLikes;
    private int price;

    public MenuDetailResponseDto(Menu menu) {
        this.storeId = menu.getStore().getId();
        this.menuName = menu.getMenuName();
        this.menuLikes = menu.getMenuLikes();
        this.price = menu.getPrice();
    }

}
