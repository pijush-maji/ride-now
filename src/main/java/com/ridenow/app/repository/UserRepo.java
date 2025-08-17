package com.ridenow.app.repository;

import com.ridenow.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    @NativeQuery("SELECT * FROM user u WHERE u.role = 2")
    Optional<List<User>> findNearByRiders();
}
