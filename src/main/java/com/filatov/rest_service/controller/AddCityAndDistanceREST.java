package com.filatov.rest_service.controller;

import com.filatov.rest_service.repository.AddCityAndDistanceRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

@RequestScoped
@Path("/add")
public class AddCityAndDistanceREST {

    @Inject
    private AddCityAndDistanceRepository addCityAndDistanceRepository;

    @POST
    @Path("/")
    @Produces({"application/xml","application/json"})
    @Consumes("application/xml")
    public Response addCityAndDistanceLists(String list) throws JAXBException {
            addCityAndDistanceRepository.addCityAndDistanceLists(list);
            return Response.ok().build();
    }
}
