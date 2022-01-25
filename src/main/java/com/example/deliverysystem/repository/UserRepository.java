package com.example.deliverysystem.repository;

import com.example.deliverysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:32
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.username= :username")
    User findUserByUsername(@Param("username") String username);

}

