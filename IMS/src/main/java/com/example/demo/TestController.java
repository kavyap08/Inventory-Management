package com.example.demo;
import org.springframework.web.bind.annotation.*;
@RestController
public class TestController {

    private final UserRepo repo;

    public TestController(UserRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/add")
    public String add() {
        User u = new User();
        u.setName("Kavya");
        repo.save(u);
        return "saved";
    }

    @GetMapping("/all")
    public Object all() {
        return repo.findAll();
    }
}
