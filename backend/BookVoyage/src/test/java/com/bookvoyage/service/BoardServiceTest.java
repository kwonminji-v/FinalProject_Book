package com.bookvoyage.service;


import com.bookvoyage.Board.BoardDTO;
import com.bookvoyage.Board.BoardEntity;
import com.bookvoyage.Board.BoardRepository;
import com.bookvoyage.Board.BoardService;
import com.bookvoyage.Member.MemberEntity;
import com.bookvoyage.Member.MemberRepository;
import com.bookvoyage.Member.Role;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Log4j2
@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("게시글_작성하기")
    public void writeBoard() {

        MemberEntity memberEntity = MemberEntity.builder().username("권민지").nickname("권판돌").email("coco@coco.co").role(Role.USER).build();

        BoardDTO.Request boardEntity = BoardDTO.Request.builder()
                .title("Test코드에서 입력한 Title")
                .writer(memberEntity.getNickname())
                .content("Test 코드에서 입력한 내용")
                .views(0)
                .member(memberEntity)
                .build();

        boardService.save(boardEntity, memberEntity.getNickname());

        log.info(String.valueOf(boardEntity));
    }

}
