package com.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

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
        return boardEntity.getId();
    }

    /**entityToDTO()를 이용해서 java.util.Function을 생성하고 BoardResponseDTO 구성하는 부분*/

    @Override
    public ResponseDTO<BoardDTO, BoardEntity> getList(RequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        Page<BoardEntity> response = boardRepository.findAll(pageable);
        Function<BoardEntity, BoardDTO> fn = (entity -> entityToDto(entity));

        return new ResponseDTO<>(response, fn);
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
