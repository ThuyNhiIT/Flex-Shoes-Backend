package com.flexshose.flexshoesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexshose.flexshoesbackend.entity.InvalidToken;

@Repository
public interface InvalidTokenRepository  extends JpaRepository<InvalidToken, String>{

}
