package com.kdt.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    public List<BoardEntity> findBoardList() {

        return boardRepository.findAll();
    }

    public BoardEntity findOne(Long id) {
        //id에 해당하는 board가 repository에 존재하지 않을 경우 NullPointerException이 발생하면
        //서버가 죽을 수 있기 때문에, 예외처리를 함께 작성
        return boardRepository.findById(id).orElseThrow(NullPointerException::new);

    }
    @Transactional
    public void create(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }

    @Transactional
    public void update( Long id, String title, String category, String content) {

        //영속성 컨텍스트에 올림 -> 캐싱을 위한 DB 접근을 최소화 하기 위해서 사용함
        BoardEntity findBoard = boardRepository.findById(id).orElseThrow(NullPointerException::new);
        findBoard.setTitle(title);
        findBoard.setCategory(category);
        findBoard.setContent(content);
    }

    @Transactional
    public void delete(BoardEntity boardEntity) {

            boardRepository.delete(boardEntity);
    }
}
