package com.bookvoyage.Board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@Builder
public class BoardRequestDTO {

    private int page;
    private int size;

    public BoardRequestDTO() {
        this.page = 1;
        this.size = 5;
    }

    public Pageable getPeageable(Sort sort) {
        return PageRequest.of(page - 1, size,sort);
    }
}
