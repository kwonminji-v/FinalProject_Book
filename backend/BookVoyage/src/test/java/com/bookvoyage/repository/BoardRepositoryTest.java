package com.bookvoyage.repository;

import com.bookvoyage.Board.BoardEntity;
import com.bookvoyage.Board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@SpringBootTest
public class BoardRepositoryTest {


    @Autowired
    private BoardRepository boardRepository;

    @Test //더미데이터 만들기
    public void insertExample() {
        IntStream.rangeClosed(1,5).forEach(i -> {
            BoardEntity boardEntity = BoardEntity.builder()
                    .category("아동 도서" + i)
                    .title("푸바오는 즐거워" + i)
                    .content("푸바오 이야기" + i)
                    .writer("작성자" + (i % 10))
                    .build();

            boardRepository.save(boardEntity);
        });
    }

    @Test
    @DisplayName("작성된_게시글_불러오기")
    public void loadBoard() {

        String title = "제목을 작성함";
        String content = "어떤 내용을 왈라왈라 작성함";

        boardRepository.save(BoardEntity.builder().title(title).content(content).writer("권민지").build());

        List<BoardEntity> boardEntityList = boardRepository.findAll();

        BoardEntity boardEntity = boardEntityList.get(0);

        assertThat(boardEntity.getTitle()).isEqualTo(title);
        assertThat(boardEntity.getContent()).isEqualTo(content);

        log.info(boardEntity);
    }

}
