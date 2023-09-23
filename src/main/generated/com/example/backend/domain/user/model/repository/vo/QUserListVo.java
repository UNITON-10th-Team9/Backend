package com.example.backend.domain.user.model.repository.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.backend.domain.user.model.repository.vo.QUserListVo is a Querydsl Projection type for UserListVo
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserListVo extends ConstructorExpression<UserListVo> {

    private static final long serialVersionUID = -604871908L;

    public QUserListVo(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> phoneNumber, com.querydsl.core.types.Expression<com.example.backend.domain.user.model.Position> position, com.querydsl.core.types.Expression<String> organization, com.querydsl.core.types.Expression<Integer> annual, com.querydsl.core.types.Expression<String> profileImageUrl, com.querydsl.core.types.Expression<String> introduce, com.querydsl.core.types.Expression<String> profileUrl) {
        super(UserListVo.class, new Class<?>[]{long.class, String.class, String.class, String.class, com.example.backend.domain.user.model.Position.class, String.class, int.class, String.class, String.class, String.class}, id, name, email, phoneNumber, position, organization, annual, profileImageUrl, introduce, profileUrl);
    }

}

