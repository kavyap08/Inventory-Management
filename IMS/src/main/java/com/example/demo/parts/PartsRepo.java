package com.example.demo.parts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PartsRepo extends JpaRepository<Parts, String>{
	List<Parts> findBySkuContainingIgnoreCaseOrPartNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(
	        String sku,
	        String partName,
	        String category
	);
}