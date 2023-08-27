package com.kdt.BookVoyage.Reply;


import com.kdt.BookVoyage.Board.BoardEntity;
import com.kdt.BookVoyage.Member.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReplyDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {

        private Long id;
        private String reply;
        private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
        private String modDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
        private MemberEntity memberEntity;
        private BoardEntity boardEntity;

        /* Dto -> Entity */
        public ReplyEntity toEntity() {
            ReplyEntity replyEntity = ReplyEntity.builder()
                    .id(id)
                    .reply(reply)
                    .regDate(regDate)
                    .modDate(modDate)
                    .memberEntity(memberEntity)
                    .boardEntity(boardEntity)
                    .build();

            return replyEntity;
        }
    }

    /**
     * 댓글 정보를 리턴할 응답(Response) 클래스
     * Entity 클래스를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
     * 별도의 전달 객체를 활용해 연관관계를 맺은 엔티티간의 무한참조를 방지
     */
    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private Long id;
        private String reply;
        private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
        private String moddDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
        private String nickname;
        private Long memberId;
        private Long boardId;


        /* Entity -> Dto*/
        public Response(ReplyEntity replyEntity) {
            this.id = replyEntity.getId();
            this.reply = replyEntity.getReply();
            this.regDate = replyEntity.getRegDate();
            this.moddDate = replyEntity.getModDate();
            this.nickname = replyEntity.getMemberEntity().getNickname();
            this.memberId = replyEntity.getMemberEntity().getId();
            this.boardId = replyEntity.getBoardEntity().getId();
        }
    }

}
