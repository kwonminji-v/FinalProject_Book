package com.example.demo.Board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;
import java.util.Date;

/**
 * page 등록을 요청할 request와 response DTO 클래스를 하나로 묶어
 * InnerStatic 클래스로 DTO 클래스 내부에 작성*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {

        //Board에서 사용할 필드 값
        private Long Id;
        private String title;
        private String category;
        private String writer;
        private String content;
        private Date date;
        private Long views;
        private String file;
        private Member member;




}
