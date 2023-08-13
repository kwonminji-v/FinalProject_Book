package com.bookvoyage.Board;


import com.bookvoyage.Member.MemberEntity;
import com.bookvoyage.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BoardDTO를 이용해 필요한 필드값을 전달받고, 반환하도록 처리하기 위해
 * BoardService 인터페이스와 인터페이스를 구현할 BoardServiceImpl을 작성 */
@Log4j2
@Service
@RequiredArgsConstructor
public class BoardService {

        private final BoardRepository boardRepository;
        private final MemberRepository memberRepository;
        
        /** 게시글 작성 (Create)*/
        @Transactional
        public Long save(BoardDTO.Request dto, String nickname) {

            //Member 정보를 가져와 dto에 담기
            MemberEntity member = memberRepository.findByNickname(nickname);
            dto.setMember(member);
            log.info("BoardService save() 메서드 실행");
            BoardEntity boardEntity = dto.dtoToEntity();
            boardRepository.save(boardEntity);

            return boardEntity.getId();
        }

        /** 게시글 조회 (READ) */

        @Transactional(readOnly = true)
        public BoardDTO.Response findById(Long id) {

            BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() ->
                    new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id : " + id));
            return new BoardDTO.Response(boardEntity);
        }

}
