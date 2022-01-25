package com.example.deliverysystem.repository;

import com.example.deliverysystem.entity.MyUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:40
 * @Version 1.0
 */

public interface UtilsRepository extends JpaRepository<MyUtils, Integer> {

    @Query("select u from MyUtils u where u.uid=?1")
    MyUtils getMyUtils(String uid);

}

