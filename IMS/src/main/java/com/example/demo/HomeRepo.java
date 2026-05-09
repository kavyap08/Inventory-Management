package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.User;
public interface HomeRepo extends JpaRepository<User, Long> {
	User findByUsernameAndPassword(String username, String password);
}
