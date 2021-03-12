package com.filatov.rest_service.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;
}
