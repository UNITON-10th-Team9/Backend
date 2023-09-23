package com.example.backend.domain.user.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'AWDAWD'")
    private String profileImageUrl;

    @Column(columnDefinition = "VARCHAR(255)")
    private String introduce;

    @Column(columnDefinition = "VARCHAR(255)")
    private String profileUrl;

    @Builder
    public User(Long id, String name, String email, String phoneNumber, Position position, String organization, int annual, String profileImageUrl, String introduce, String profileUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.organization = organization;
        this.annual = annual;
        this.profileImageUrl = profileImageUrl;
        this.introduce = introduce;
        this.profileUrl = profileUrl;
    }

    public User updateId(Long id) {
        this.id = id;
        return this;
    }
}
