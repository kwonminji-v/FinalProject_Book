package com.example.demo.Board;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {


/*
    @GetMapping("/list") //게시판 게시글 리스트
    public void list(@ModelAttribute BoardDTO boardDto, Model model) {
        model.addAttribute("result", boardService.getList() );
    }
*/

}
