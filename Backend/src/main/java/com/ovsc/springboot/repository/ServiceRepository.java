package com.ovsc.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.ovsc.springboot.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}



