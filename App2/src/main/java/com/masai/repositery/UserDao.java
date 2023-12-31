package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
