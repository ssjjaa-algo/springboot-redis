package com.example.redis.test.controller;

import com.example.redis.test.domain.Board;
import com.example.redis.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestBody Board board) {

        testService.regist(board, board.getUserId());

        return ResponseEntity.ok("등록완료");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Board>> getAll() {
        return ResponseEntity.ok().body(
                testService.getAll("강병선"));
    }

}
