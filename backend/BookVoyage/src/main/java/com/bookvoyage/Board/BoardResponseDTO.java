package com.bookvoyage.Board;


import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 페이징 처리 결과를 Page<Entity> 타입으로 반환한 후 자료구조에 담기
 * 다양한 곳에서 사용할 수 있기 위해 제네릭 타입 사용
 * Function의 역할은 엔티티 객체들을 DTO로 변환해주는 기능
 * */


@Data
public class BoardResponseDTO<DTO, EN> {

    private List<DTO> dtoList;

    private int totalPage; //총 페이지 번호
    private int page; //현재 페이지 번호
    private int size; //목록 사이즈
    private int start, end; // 시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next;  //이전, 다음
    private List<Integer> boardList; //페이지 번호 목록

    public BoardResponseDTO(Page<EN> response , Function<EN,DTO> fn) {

        dtoList = response.stream().map(fn).collect(Collectors.toList());
        totalPage = response.getTotalPages();
        makeBoardList(response.getPageable());
    }

    private void makeBoardList(Pageable pageable) {

        this.page = pageable.getPageNumber() + 1; //Paging이 0부터 시작하기 때문에 + 1로 1부터 시작 설정
        this.page = pageable.getPageSize();

        // temp end page
        // 끝번호를 미리 계산하는 이유 : 시작번호 계산 수월하게 하기위해
        int tempEnd = (int)(Math.ceil(page/10.0)) * 10;

        start = tempEnd -9;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        prev = start > 1;
        next = totalPage > tempEnd;

        boardList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());

    }
}
