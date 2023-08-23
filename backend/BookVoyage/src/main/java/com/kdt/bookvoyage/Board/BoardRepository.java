package com.kdt.bookvoyage.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findByTitleContaining(String keyword);

/*    @Query(value = "SELECT MAX(ID) FROM BoardEntity WHERE deleted = true", nativeQuery = true)
    Long findMaxDeleteId();

    @Modifying
    @Query(value = "ALTER TABLE board AUTO_INCREMENT = :startValue", nativeQuery = true)
    void setAutoIncrementStart(Long startValue);*/



}
