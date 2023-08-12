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
public class RequestDTO {

    private int page;
    private int size;

    public RequestDTO() {
        this.page = 1;
        this.size = 5;
    }

    public Pageable getPageable(Sort sort) {
        // 페이지 번호가 0부터 시작한다는 점을 감안해 1페이지의 경우 0이 될수 있도록 page -1로 작성해준다
        // 정렬은 다양한 상황에서 쓰기위해 별도의 파라미터로 받도록 설계
        return PageRequest.of(page - 1, size, sort);
    }
}
