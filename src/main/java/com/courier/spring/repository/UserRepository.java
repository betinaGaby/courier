package com.courier.spring.repository;

import com.courier.spring.model.Usermodel;
import com.courier.spring.model.Usermodel;
import com.courier.spring.service.Implementation.UserImplemantation;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usermodel, Integer> {

    Optional<Usermodel> findByEmailAndPassword(String email, String password);
}
