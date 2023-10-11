package com.example.redis.test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name="test")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @Column(name="sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_id")
    private String userId;

    @Column(name="user_name")
    private String userName;

}
