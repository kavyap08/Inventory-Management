package com.example.demo.procurement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrService {

    @Autowired
    private PrRepo prRepo;

    public void save(Pr pr) {

        prRepo.save(pr);
    }

    public List<Pr> findAllPR() {

        return prRepo.findAllByOrderByCreatedAtDesc();
    }

}	