package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.*;
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
 
}