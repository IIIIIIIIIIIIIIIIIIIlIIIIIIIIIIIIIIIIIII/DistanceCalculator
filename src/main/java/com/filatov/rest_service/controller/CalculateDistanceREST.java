package com.filatov.rest_service.controller;

import com.filatov.rest_service.repository.CalculateDistanceRepository;
import com.filatov.rest_service.entity.additionalclass.CityListFromTo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

@RequestScoped
@Path("/calculate")
public class CalculateDistanceREST {

    @Inject
    private CalculateDistanceRepository calculateDistanceRepository;

    @POST
    @Path("/{calculateType}")
    @Produces("text/plain")
    @Consumes({"application/xml","application/json"})
    public StringBuilder calculateDistance (@PathParam("calculateType") String calculateType, CityListFromTo cityListFromTo){
            return calculateDistanceRepository.calculateDistance(calculateType, cityListFromTo);
    }
}
