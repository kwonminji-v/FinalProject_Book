package com.bookvoyage.repository;

import com.bookvoyage.Board.BoardEntity;
import com.bookvoyage.Board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

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

}
