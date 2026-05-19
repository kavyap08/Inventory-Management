package com.example.demo.user;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Long> {
User findByUsernameAndPassword(String username, String password);
	
	User findByIdAndUsername(Long id, String username);
	
	User findByUsername(String username);
	
	List<User> findByRole(String role);
}