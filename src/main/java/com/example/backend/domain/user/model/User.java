package com.example.backend.domain.user.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "tbl_usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(64)", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "", nullable = false)
    private Position position;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String organization;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private int annual;

    @Column(columnDefinition = "VARCHAR(255)")
    private String profileImageUrl;

    @Column(columnDefinition = "VARCHAR(255)")
    private String introduce;

    @Column(columnDefinition = "VARCHAR(255)")
    @Builder.Default
    private String profileUrl="";

    public User updateId(Long id) {
        this.id = id;
        return this;
    }
}
