package com.example.backend.domain.user.model.repository;

import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.repository.vo.QUserListVo;
import com.example.backend.domain.user.model.repository.vo.UserListVo;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.backend.domain.user.model.QUser.user;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<UserListVo> findAllByPositionAndOrderType(Position position, OrderType orderType) {
        JPAQuery<UserListVo> query = queryFactory.select(new QUserListVo(
                        user.id,
                        user.name,
                        user.email,
                        user.phoneNumber,
                        user.position,
                        user.organization,
                        user.annual,
                        user.profileImageUrl,
                        user.introduce,
                        user.profileUrl
                )).from(user)
                .where(user.position.eq(position));

        if (orderType == OrderType.ASC) {
            query.orderBy(user.id.asc());
        } else if (orderType == OrderType.DESC) {
            query.orderBy(user.id.desc());
        }

        return query.fetch();
    }
}
