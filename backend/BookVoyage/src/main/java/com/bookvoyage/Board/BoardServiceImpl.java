/*
package com.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository; //반드시 final로 선언

    @Override
    public Long register(BoardDTO dto) {
        log.info("DTO에서 Entity 변환");
        log.info(dto);

        BoardEntity entity = dtoToEntity(dto);
        log.info(entity);
        boardRepository.save(entity);
        return entity.getId();
    }

    */
/**entityToDTO()를 이용해서 java.util.Function을 생성하고 BoardResponseDTO 구성하는 부분*//*


    @Override
    public ResponseDTO<BoardDTO, BoardEntity> getList(RequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        Page<BoardEntity> result = boardRepository.findAll(pageable);
        Function<BoardEntity, BoardDTO> fn = (entity -> entityToDto(entity));

        return new ResponseDTO<>(result, fn);
    }


    @Override
    public BoardDTO read(Long id) {
        */
/** findById를 통해 entity 객체를 가져온 후 DTO로 변환 *//*

        Optional<BoardEntity> result = boardRepository.findById(id);
        return result.isPresent() ? entityToDto(result.get()) : null;
    }

    @Override
    public void remove(Long id) {

    }

*/
/*    @Override
    public void modify(BoardDTO dto) {

        *//*
*/
/** 업데이트 하는 항목 선정 가능*//*
*/
/*
        Optional<BoardEntity> response = boardRepository.findById(dto.getId());

        if( response.isPresent() ) {
            BoardEntity entity = response.get();
        }

    }*//*


}
*/
