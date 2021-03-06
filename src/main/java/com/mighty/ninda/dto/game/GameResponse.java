package com.mighty.ninda.dto.game;

import com.mighty.ninda.domain.game.Game;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameResponse {

    private Long id;
    private String title;
    private String description;
    private String pageUrl;
    private String imgUrl;
    private String releasedDate;
    private String price;
    private String language;
    private int reLike;
    private int reHate;
    private String onSale;
    private String salePrice;
    private String startSaleDate;
    private String endSaleDate;

    @Builder
    public GameResponse(Long id, String title, String description, String pageUrl, String imgUrl, LocalDate releasedDate, String price, String language,
                        int reLike, int reHate, String onSale, String salePrice, LocalDate startSaleDate, LocalDate endSaleDate) {
        this.id = id;
        this.title = title;
        this.description = description.replace("\n", "<br>");
        this.pageUrl = pageUrl;
        this.imgUrl = imgUrl;
        this.releasedDate = releasedDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.price = price;
        this.language = language;
        this.reLike = reLike;
        this.reHate = reHate;
        this.onSale = onSale;
        this.salePrice = salePrice;
        if (onSale.equals("on")) {
            this.startSaleDate = startSaleDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            this.endSaleDate = endSaleDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        }
    }

    public static GameResponse of(Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .title(game.getTitle())
                .description(game.getDescription())
                .pageUrl(game.getPageUrl())
                .imgUrl(game.getImgUrl())
                .releasedDate(game.getReleasedDate())
                .price(game.getPrice())
                .language(game.getLanguage())
                .reLike(game.getReLike())
                .reHate(game.getReHate())
                .onSale(game.getOnSale())
                .salePrice(game.getSalePrice())
                .startSaleDate(game.getStartSale())
                .endSaleDate(game.getEndSale())
                .build();
    }
}
