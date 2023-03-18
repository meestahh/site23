package com.example.site23;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BarbershopRepository extends JpaRepository<Barbershop,Long>{
    @Query("SELECT p FROM Barbershop p WHERE concat(p.fio, '', p.date_action, '', p.name_, '', p.master_) LIKE %?1%")
    List<Barbershop> search(String keyword);
}
