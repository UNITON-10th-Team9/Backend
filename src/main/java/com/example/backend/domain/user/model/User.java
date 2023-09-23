package com.example.backend.domain.user.model;

import com.example.backend.domain.user.controller.dto.request.SaveUserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "tbl_usr")
public class User {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(columnDefinition = "VARCHAR(255) DEFAULT = Awd", nullable = false)
    private String profileImageUrl;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String introduce;

    @Column(columnDefinition = "VARCHAR(255)")
    private String profileUrl;

    public void setUserInformation(final SaveUserRequest dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.position = dto.getPosition();
        this.organization = dto.getOrganization();
        this.annual = dto.getAnnual();
        this.profileImageUrl = dto.getProfileImageUrl();
        this.introduce = dto.getIntroduce();
        this.profileUrl = dto.getProfileUrl();
    }
}
