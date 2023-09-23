package com.example.backend.domain.user.model.repository;

import com.example.backend.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    void updateUserById(Long id, User user);
}
