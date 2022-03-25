package com.arshaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arshaa.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
