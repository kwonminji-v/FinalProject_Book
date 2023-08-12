package com.bookvoyage.Board;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String category;
    @Column
    private String writer;
    @Column
    private String content;

/*    @Column(columnDefinition = "integer default 0")
    private int b_views;
    @Column
    private String b_file;*/



}
