package com.kdt.bookvoyage.Board;



import com.kdt.bookvoyage.Member.MemberEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@Data
@NoArgsConstructor
public class BoardDTO {

    private Long id;

    private String title;
    private String category;
    private String writer;
    private String content;
    private int view;
    private MemberEntity member;
    private String regDate, modDate;
    private Long memberId;

    public static BoardDTO EntityToDto(BoardEntity boardEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(boardEntity, BoardDTO.class);
    }

    public BoardDTO(BoardEntity boardEntity) {
        this.id = boardEntity.getId();
        this.title = boardEntity.getTitle();
        this.category = boardEntity.getCategory();
        this.writer = boardEntity.getWriter();
        this.content = boardEntity.getContent();
        this.view = boardEntity.getView();
        this.member = boardEntity.getMember();
        this.regDate = boardEntity.getRegDate();
        this.modDate = boardEntity.getModDate();
        this.memberId = boardEntity.getMember().getId();
    }
}
