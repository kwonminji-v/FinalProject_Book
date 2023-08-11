package com.example.demo.Board;


import jakarta.persistence.*;

import java.util.Date;

@Entity

@Table(name = "qna_board")
public class BoardEntity {

    @Id @GeneratedValue
    @Column
    private Long b_Id;

    @Column
    private String b_title;

    @Column
    private String b_username;

    @Column
    private String b_writer;

    @Column
    private String b_content;

    @Column
    private Date b_date;

    @Column
    private Long b_views;

    @Column
    private String b_file;



}
