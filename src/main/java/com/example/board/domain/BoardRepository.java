package com.example.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.board.domain.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

}
