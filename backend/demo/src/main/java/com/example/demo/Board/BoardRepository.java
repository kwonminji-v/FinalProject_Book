package com.example.demo.Board;



import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;



@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {



}
