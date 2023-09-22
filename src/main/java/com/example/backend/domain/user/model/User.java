package com.example.backend.domain.user.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_usr")
public class User {

    @Id
    @PrimaryKeyJoinColumn
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
    private String annual;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT = Awd", nullable = false)
    private String profileImageUrl;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String introduce;

    @Column(columnDefinition = "VARCHAR(255)")
    private String url;
}
