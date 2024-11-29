package com.flexshose.flexshoesbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {

}
