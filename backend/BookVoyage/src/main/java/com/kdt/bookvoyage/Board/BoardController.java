package com.kdt.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board-list")
    public WrapperClass board_list() {

        List<BoardEntity> boardList = boardService.findBoardList();
        List<BoardDTO> boardDTOList = boardList.stream()
                .map(BoardDTO::new)
                .collect(Collectors.toList());

        return new WrapperClass(boardDTOList);
    }

    @GetMapping("/board-detail/{boardId}")
    public WrapperClass board_detail(@PathVariable("boardId") Long id) {

        BoardEntity boardEntity = boardService.findOne(id);
        BoardDTO boardDTO = new BoardDTO(boardEntity);

        return new WrapperClass(boardDTO);

    }

    @PostMapping("/create-board")
    public ResponseEntity create_board(@RequestBody BoardDTO boardDTO) {

        System.out.println("게시글 작성 완료 = " + boardDTO);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED; //201 메세지로 잘 생성되었음을 확인

        try{
            BoardEntity boardEntity = new BoardEntity (
                            boardDTO.getId(),
                            boardDTO.getTitle(),
                            boardDTO.getCategory(),
                            boardDTO.getWriter(),
                            boardDTO.getContent(),
                            boardDTO.getView()

            );
            boardService.create(boardEntity);
        }catch (Exception exception) {
            status = HttpStatus.BAD_REQUEST;  //404에러
            System.out.println("게시글 작성 예외 발생 : " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

    @PutMapping("/update-board")
    public ResponseEntity update_board(@RequestBody BoardDTO boardDTO) {
        System.out.println("게시글 수정 코드 DTO = " + boardDTO);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT;  //204 -> 수정이 정상적으로 완료
        try{

            boardService.update(boardDTO.getId(),
                    boardDTO.getTitle(),
                    boardDTO.getCategory(),
                    boardDTO.getContent());
        } catch (Exception exception) {
            status = HttpStatus.BAD_REQUEST;  // 400에러 발생
            System.out.println("게시글 수정 에러 발 생 = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

    @DeleteMapping("/delete-board")
    public ResponseEntity delete_board(@RequestBody BoardDeleteDTO boardDeleteDTO) {
        System.out.println("게시글 삭제 컨트롤러 실행 DTO = " + boardDeleteDTO);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT; //204 에러

        try {
            BoardEntity boardEntity = boardService.findOne(boardDeleteDTO.getId());
            boardService.delete(boardEntity);
        } catch (Exception exception) {
            status = HttpStatus.BAD_REQUEST;
            System.out.println("게시글 삭제 예외 발생 = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

}
