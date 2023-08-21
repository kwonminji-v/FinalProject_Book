package com.kdt.bookvoyage.Service;


import com.kdt.bookvoyage.Board.BoardDTO;
import com.kdt.bookvoyage.Board.BoardEntity;
import com.kdt.bookvoyage.Board.BoardRepository;
import com.kdt.bookvoyage.Board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 생성하기")
    public void writeBoard() {

        BoardEntity boardEntity = BoardEntity.builder()
                .title("게시글 제목")
                .category("분야")
                .content("게시글 내용은 이렇습니다.")
                .writer("작성자")
                .build();

        boardService.create(boardEntity);
    }

    @Test
    @DisplayName("게시글 리스트 조회해보기")
    public void makeBoardList() {

        List<BoardEntity> boardList = boardService.findBoardList();
        boardList.stream().map(b -> boardList).collect(Collectors.toList());

    }

}
