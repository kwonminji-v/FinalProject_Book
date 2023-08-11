package com.bookvoyage.Board;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardEntity extends BaseEntity {

    @Id @GeneratedValue
    private Long b_id;
    @Column
    private String b_title;
    @Column
    private String b_category;
    @Column
    private String b_writer;
    @Column
    private String b_content;
/*    @Column(columnDefinition = "integer default 0")
    private int b_views;
    @Column
    private String b_file;*/



}
