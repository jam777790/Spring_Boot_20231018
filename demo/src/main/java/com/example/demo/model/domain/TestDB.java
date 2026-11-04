
package com.example.demo.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "testdb")
@Data
public class TestDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    // 나이
    @Column(nullable = true)
    private Integer age;

    // 성별
    @Column(nullable = true, length = 10)
    private String gender;
}
