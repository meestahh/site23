package com.example.site23;//1-й класс

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.HashMap;


@Entity
public class Barbershop {
    public long id;//id
    public String fio;//тип техники
    public String date_action;//Дата ввоза на склад
    public String name_;//Дата вывоза со склада
    public String master_;//Имя

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDate_action() {
        return date_action;
    }

    public void setDate_action(String date_action) {
        this.date_action = date_action;
    }

    public String getName_() {return name_;}

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getMaster_() {
        return master_;
    }

    public void setMaster_(String master_) {
        this.master_ = master_;
    }


}

