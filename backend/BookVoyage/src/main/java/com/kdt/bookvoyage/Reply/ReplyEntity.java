package com.kdt.bookvoyage.Reply;


import com.kdt.bookvoyage.Board.BaseEntity;
import com.kdt.bookvoyage.Board.BoardEntity;
import com.kdt.bookvoyage.Member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "REPLY")
public class ReplyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reply; // 댓글 내용

    @Column(name = "regDate")
    @CreatedDate
    private String regDate;

    @Column(name = "modDate")
    @LastModifiedDate
    private String modDate;

    @ManyToOne
    @JoinColumn(name = "b_id")
    private BoardEntity boardEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MemberEntity memberEntity; // 작성자



}

