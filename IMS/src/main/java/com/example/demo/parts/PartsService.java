package com.example.demo.parts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartsService {
@Autowired
private PartsRepo partsrepo;

public List<Parts> findAllParts(){
	return partsrepo.findAll();
}

public void addPart(Parts part) {
	partsrepo.save(part);
}

public List<Parts> searchParts(String keyword) {

    if(keyword == null || keyword.trim().isEmpty()) {
        return partsrepo.findAll();
    }

    return partsrepo.findBySkuContainingIgnoreCaseOrPartNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            keyword,
            keyword,
            keyword
    );
}
}