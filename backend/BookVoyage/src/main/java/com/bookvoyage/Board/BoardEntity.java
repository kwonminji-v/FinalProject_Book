package com.bookvoyage.Board;


import com.bookvoyage.Member.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private Long id;

    @Column(name = "b_title")
    private String title;

    @Column(name = "b_content")
    private String content;

    @Column(name = "b_category")
    private String category;

    @Column(name = "b_writer")
    private String writer;

    @Column(columnDefinition = "integer default 0", nullable = false, name = "b_views")
    private int views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;


/*    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;*/

    /* 게시글 수정 */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
