package com.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"/", "/list"})
    public String index(){
        return "board/list";
    }

/*    @GetMapping("/list")
    public String list(@ModelAttribute BoardRequestDTO boardRequestDTO , Model model){

        // 실제로 model에 추가되는 데이터 : BoardRequestDTO
        // => Model을 이용해 BoardServiecImpl에서 반환하는 PageResultDTO를 result 라는 이름으로 전달
        model.addAttribute("response", boardService.getList(boardRequestDTO));
        return "board/list";
    }*/


    // 화면을 보여준다
    @GetMapping("/register")
    public String register(){
        return "board/register";

    }
    // 처리 후 목록 페이지로 이동
    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        // 새로 추가된 엔티티의 번호
        Long id = boardService.register(boardDTO);

        // addFlashAttribute() : 단 한번만 데이터를 전달하는 용도로 사용한다
        // redirectAttributes : 한 번만 화면에서 "msg"라는 이름의 변수를 사용할 수 있도록 처리
        redirectAttributes.addFlashAttribute("msg", id);

        return "redirect:/board/list";
    }

}
