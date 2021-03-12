package com.filatov.rest_service.controller;

import com.filatov.rest_service.repository.CityRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@RequestScoped
@Path("/city")
public class CityREST {

    @Inject
    private CityRepository cityRepository;

    @GET
    @Path("/")
    @Produces("application/json")
    public List<String> getAllCities(){
        return cityRepository.getAll();
    }
}
