package com.example.deliverysystem.repository;

import com.example.deliverysystem.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:27
 * @Version 1.0
 */
public interface CuisineRepository extends JpaRepository<Cuisine, Integer> {
    @Modifying
    @Transactional
    @Query("delete  from Cuisine c where  c.cid>4")
    void deleteNewCuisine();
}
