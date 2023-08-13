package com.bookvoyage.Board;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    @Modifying
    @Query("update BoardEntity b_entity set b_entity.views = b_entity.views + 1 where b_entity.id = :id")
    int updateView(Long id);

    Page<BoardEntity> findByTitleContaining(String keyword, Pageable pageable);

}
