package com.example.demo.repository;

import com.example.demo.model.TextData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextDataRepository extends JpaRepository<TextData, Long> {

}
