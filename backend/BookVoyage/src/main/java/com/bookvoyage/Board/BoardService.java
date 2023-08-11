package com.bookvoyage.Board;


import org.springframework.stereotype.Service;

/**
 * BoardDTO를 이용해 필요한 필드값을 전달받고, 반환하도록 처리하기 위해
 * BoardService 인터페이스와 인터페이스를 구현할 BoardServiceImpl을 작성 */
public interface BoardService {

    /**service에서는 파라미터를 DTO 타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요
     * java 8 버전부터 인터페이스의 실제 내용을 가지는 코드는 default라는 키워드로 생성할 수 있다
     * -> 실제 코드를 인터페이스에 선언할 수 있다 => 추상클래스를 생략하는것이 가능해 졌다*/
    Long register(BoardDTO boardDTO);
    BoardResponseDTO<BoardDTO, BoardEntity> getList(BoardRequestDTO boardRequestDTO);

    default BoardEntity dtoToEntity(BoardDTO boardDTO) {

        BoardEntity boardEntity = BoardEntity.builder()
                .b_id(boardDTO.getId())
                .b_title(boardDTO.getTitle())
                .b_category(boardDTO.getCategory())
                .b_writer(boardDTO.getWriter())
                .b_content(boardDTO.getContent())
                .build();

        return boardEntity;
    }

    default BoardDTO entityToDto(BoardEntity boardEntity) {

        BoardDTO boardDTO = BoardDTO.builder()
                .id(boardEntity.getB_id())
                .title(boardEntity.getB_title())
                .category(boardEntity.getB_category())
                .writer(boardEntity.getB_writer())
                .content(boardEntity.getB_content())
                .build();

        return boardDTO;
    }

    BoardDTO read(Long id);

    void remove(Long id);

    void modify(BoardDTO boardDTO);

}
