package com.example.redis.test.repository;

import com.example.redis.test.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Board,Long> {

    List<Board> findAllByUserId(String id);
}
