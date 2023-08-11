package com.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository; //반드시 final로 선언

    @Override
    public Long register(BoardDTO boardDTO) {
        log.info("DTO에서 Entity 변환");
        log.info(boardDTO);

        BoardEntity boardEntity = dtoToEntity(boardDTO);
        log.info(boardEntity);
        boardRepository.save(boardEntity);
        return boardEntity.getB_id();
    }

    @Override
    public BoardResponseDTO<BoardDTO, BoardEntity> getList(BoardRequestDTO boardRequestDTO) {
        return null;
    }

    @Override
    public BoardDTO read(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void modify(BoardDTO boardDTO) {

    }

}
