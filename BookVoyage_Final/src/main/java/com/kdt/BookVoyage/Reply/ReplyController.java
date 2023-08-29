package com.kdt.BookVoyage.Reply;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/board-detail/{id}/reply-list")
    public ResponseEntity<ReplyDTO.ReplyResponseDTO> replyCreate(@PathVariable Long id, @RequestBody ReplyDTO.ReplyRequestDTO dto) {

        Long replyId = replyService.replyCreate(id, dto);
        ReplyEntity createdReply = replyService.findOneReply(replyId);
        ReplyDTO.ReplyResponseDTO responseDTO = new ReplyDTO.ReplyResponseDTO(createdReply);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/board-detail/{id}/reply-list")
    public ResponseEntity<List<ReplyDTO.ReplyResponseDTO>> getReplies(@PathVariable Long id) {

        List<ReplyEntity> replyList = replyService.findReplyList(id);

        List<ReplyDTO.ReplyResponseDTO> responseDTOList = replyList.stream()
                .map(reply -> {
                    ReplyDTO.ReplyResponseDTO responseDTO = new ReplyDTO.ReplyResponseDTO(reply);
                    responseDTO.setNickname(reply.getMemberEntity().getNickname()); // 닉네임 추가
                    return responseDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOList);

    }

}

