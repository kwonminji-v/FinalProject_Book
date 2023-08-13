package com.bookvoyage.Board;


import com.bookvoyage.Member.MemberEntity;
import lombok.*;
import com.bookvoyage.Board.BoardEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Board와 관련된 데이터 전달을 위한 DTO 클래스 정의 */
public class BoardDTO {


    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Request { /** 게시글의 등록과 수정을 요청(request)할 DTO클래스를 내부 클래스로 설정 */

        private Long id;
        private String title;
        private String category;
        private String writer;
        private String content;
        private int views;
        private MemberEntity member;
        private String regDate, modDate;

        public BoardEntity dtoToEntity() {
            BoardEntity boardEntity = BoardEntity.builder()
                    .id(id)
                    .title(title)
                    .category(category)
                    .writer(writer)
                    .content(content)
                    .views(0)
                    .member(member)
                    .build();

            return boardEntity;
        }

    }


    /**
     * 게시글 정보를 리턴할 응답(Response) 클래스
     * Entity 클래스를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
     * 별도의 전달 객체를 활용해 연관관계를 맺은 엔티티간의 무한참조를 방지
     */

    @Getter
    public static class Response {
        private final Long id;
        private final String title;
        private final String category;
        private final String writer;
        private final String content;
        private final String regDate, modDate;
        private final int views;
        private final Long memberId;
        //private final List<CommentDto.Response> comments;


        /**
         * Entity를 Response DTO로 변환하는 생성자
         */
        public Response(BoardEntity boardEntity) {
            this.id = boardEntity.getId();
            this.title = boardEntity.getTitle();
            this.category = boardEntity.getCategory();
            this.writer = boardEntity.getWriter();
            this.content = boardEntity.getContent();
            this.regDate = boardEntity.getRegDate();
            this.modDate = boardEntity.getModDate();
            this.views = boardEntity.getViews();
            this.memberId = boardEntity.getMember().getId();
            //this.comments = posts.getComments().stream().map(CommentDto.Response::new).collect(Collectors.toList());

            /**
             * Response 클래스는 게시글 정보를 리턴할 응답(Response) DTO 클래스입니다.
             * Response 클래스의 생성자는 Posts Entity를 받아와 해당 Entity의 정보를 활용하여 Response DTO를 생성합니다.
             * Entity의 필드값을 DTO에 복사하고, 연관된 댓글 정보도 DTO로 변환하여 할당합니다.*/

        }
    }
}

/**
 * Entity에서 DTO로 변환하는 이유:
 *
 * Entity는 데이터베이스의 테이블과 매핑되는 클래스로, 데이터베이스에 저장되거나 조회되는 정보를 가지고 있습니다. 그러나 Entity는 종종 추가적인 정보를 포함하거나 연관된 엔티티와의 관계를 가지므로, API 응답이나 뷰로 전달할 때 불필요한 정보를 노출할 수 있습니다.
 * DTO는 필요한 데이터만을 담고 있는 객체로, 클라이언트에게 전송하는 데이터의 형태를 제어하거나 연관관계로 인한 무한 참조 문제를 해결하기 위해 사용됩니다.
 * Entity와 DTO를 분리함으로써 클라이언트와의 데이터 교환 형식을 제어하고 뷰와 도메인 모델의 분리를 유지할 수 있습니다.
 * 또한, Entity의 필드에 직접 접근하거나 변경하는 것을 방지하여 데이터 일관성을 유지할 수 있습니다.
 * DTO에서 Entity로 변환하는 이유:
 *
 * 게시글 작성 등의 요청이 들어올 때 클라이언트에서 보낸 데이터를 Entity로 변환하여 데이터베이스에 저장해야 합니다.
 * DTO를 통해 전달받은 데이터를 Entity로 변환하여 올바른 데이터 저장 및 관리를 수행할 수 있습니다.
 * DTO에 있는 필드를 Entity 객체에 할당하고, 필요한 연관관계 설정 등을 처리합니다.
 * 이렇게 Entity와 DTO를 분리하여 사용함으로써 데이터의 가독성, 유지보수성, 보안 등을 향상시킬 수 있습니다.*/






/**
 *
 * 해당 코드는 게시글 관련 DTO(Data Transfer Object) 클래스를 정의하고 있습니다. DTO는 데이터 전달을 위한 객체로,
 * 주로 엔티티(Entity)와 클라이언트 사이에서 데이터를 주고받을 때 사용됩니다.
 * 이 코드는 게시글 등록과 조회에 필요한 데이터를 요청(Request) 및 응답(Response) 클래스로 나누어 정의하고 있습니다.
 *
 * Request 클래스 정의:
 *
 * Request 클래스는 게시글 등록과 수정을 처리하는 요청 정보를 담고 있습니다.
 * 필드로는 게시글의 id, title, writer, content, createdDate, modifiedDate, view, 그리고 작성자 정보를 나타내는 user가 있습니다.
 * Lombok 어노테이션(@Data, @AllArgsConstructor, @NoArgsConstructor, @Builder)을 사용하여 각 필드의 Getter, Setter, 생성자 등을 자동으로 생성합니다.
 * toEntity() 메서드는 해당 요청 정보를 기반으로 게시글 엔티티 객체를 생성하고 반환합니다. 이때, 빌더 패턴을 활용하여 엔티티 객체를 생성합니다.
 * Response 클래스 정의:
 *
 * Response 클래스는 게시글 정보를 조회할 때 사용되는 응답 정보를 담고 있습니다.
 * 필드로는 게시글의 id, title, writer, content, createdDate, modifiedDate, view, 작성자의 userId, 그리고 댓글 정보를 담고 있는 comments가 있습니다.
 * Lombok 어노테이션(@Getter)을 사용하여 필드의 Getter를 자동으로 생성합니다.
 * 생성자 파라미터로 받은 게시글 엔티티를 DTO로 변환하여 필드에 저장합니다.
 * 연관된 댓글 정보를 CommentDto.Response 객체로 변환하여 리스트로 저장합니다.
 * 이렇게 정의된 DTO 클래스들은 클라이언트와 백엔드 간 데이터 전달을 효율적으로 관리하고, 엔티티와의 무한 참조 문제를 방지하기 위해 사용됩니다.
 * 요청(Request) 클래스는 클라이언트에서 전달된 데이터를 엔티티로 변환하는 역할을 하며,
 * 응답(Response) 클래스는 엔티티를 클라이언트에게 전달하기 위한 형태로 변환하는 역할을 합니다.*/