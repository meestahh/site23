package com.example.site23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbershopService {
    @Autowired
    private BarbershopRepository repo;

    public List<Barbershop> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void save(Barbershop Barbershop) {
        repo.save(Barbershop);
    }

    public Barbershop get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
