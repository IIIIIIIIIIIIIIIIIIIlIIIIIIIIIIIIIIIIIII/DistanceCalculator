package com.filatov.rest_service.repository;

import com.filatov.rest_service.entity.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CityRepository {

    @PersistenceContext
    private EntityManager em;

    public List<String> getAll() {

        List<City> sityList = em.createQuery("SELECT city FROM City city").getResultList();

        return sityList.stream().map(e -> "ID: " + e.getId() + ", Name: " + e.getName()).collect(Collectors.toList());
    }
}
