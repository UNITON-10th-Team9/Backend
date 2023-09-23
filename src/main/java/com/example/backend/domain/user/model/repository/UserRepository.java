package com.example.backend.domain.user.model.repository;

import com.example.backend.domain.user.model.Position;
import com.example.backend.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByPhoneNumber(final String phoneNumber);

    List<User> findByPositionOrderByAnnual(final Position position);

    List<User> findByPositionOrderByAnnualDesc(final Position position);

    List<User> findAllByOrderByAnnualAsc();

    List<User> findAllByOrderByAnnualDesc();

}
