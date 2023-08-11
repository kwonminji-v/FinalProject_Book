package com.example.demo.Board;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //테이블로 생성되지 않도록 해주는 어노테이션
@EntityListeners(value = {AuditingEntityListener.class})
//AuditingEntityListener : JPA 내부에서 엔티티 객체가 생성/변경 되는 것을 감지하는 역할
@Getter
public class BaseEntity {

    @CreatedDate //Board 엔티티의 생성시간을 처리
    @Column(name = "regtime", updatable = false) //update=false -> 객체를 DB에 반영 할 때, regdate 컬럼 값은 변경되지 않음
    private LocalDateTime regDate;

    @LastModifiedDate //Board 엔티티의 마지막 수정 시간을 자동으로 처리
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
