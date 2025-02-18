package com.ovsc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ovsc.springboot.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}



