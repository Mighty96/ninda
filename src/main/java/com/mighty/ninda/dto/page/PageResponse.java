package com.mighty.ninda.dto.page;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@NoArgsConstructor
@Getter
public class PageResponse<T> {

    private final static int VIEWPAGESIZE = 12;
    private int startPage;
    private int endPage;
    private int totalPages;
    private List<T> contents;

    private PageResponse(int startPage, int endPage, int totalPages, List<T> contents) {
        this.startPage = startPage;
        this.endPage = endPage;
        this.totalPages = totalPages;
        this.contents = contents;
    }

    public static <T, G> PageResponse of(Page<G> entities, List<T> contents) {
        int totalPages = entities.getTotalPages();
        int nowPage = entities.getPageable().getPageNumber() + 1;
        int startPage = 1 * VIEWPAGESIZE * (nowPage / VIEWPAGESIZE);
        int endPage = startPage + VIEWPAGESIZE - 1;

        return new PageResponse<>(startPage == 0 ? 1 : startPage, endPage > totalPages ? totalPages : endPage, totalPages, contents);
    }
}