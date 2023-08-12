package com.bookvoyage.Board;


import jdk.jshell.Snippet;
import lombok.*;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * request, response DTO클래스를 하나로 묶어 내부static클래스로 관리
 * Entity <-> DTO 변환 기능을 작성 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String category;
    private String writer;
    private String content;
    private LocalDateTime regDate, modDate;

    /*
    private int views;
    private String file;
    private Member member;
    */

}


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