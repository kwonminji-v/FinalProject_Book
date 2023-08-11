package com.bookvoyage.Board;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Controller
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;



    @GetMapping({"/", "list"})
    public String index() {
        log.info("list목록 좀 띄워줘라!!!!!!!!!!!!!!!!!!!");
        return "board/list";
    }

/*
    @GetMapping("/list")
        public void list(@ModelAttribute BoardRequestDTO boardRequestDTO, Model model) {
            model.addAttribute("response", boardService.getList(boardRequestDTO));
        }
*/


}
