package com.example.demo.procurement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrRepo
        extends JpaRepository<Pr, Long> {

    List<Pr> findAllByOrderByCreatedAtDesc();

}