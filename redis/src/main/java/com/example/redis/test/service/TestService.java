package com.example.redis.test.service;

import com.example.redis.test.domain.Board;
import com.example.redis.test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Cacheable(value="boardList",key="#id")
    public List<Board> getAll(String id) {
        return testRepository.findAllByUserId(id);
    }

    @CacheEvict(value="boardList",key="#id")
    public void regist(Board board, String id) {
        testRepository.save(board);

    }
}
