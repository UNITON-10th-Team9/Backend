package com.example.backend.domain.user.model.repository;

import com.example.backend.domain.user.model.OrderType;
import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.repository.vo.UserListVo;

import java.util.List;

public interface CustomUserRepository {

    List<UserListVo> findAllByPositionAndOrderType(Position position, OrderType orderType);
}
