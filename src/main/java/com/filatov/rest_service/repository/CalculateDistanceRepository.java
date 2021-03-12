package com.filatov.rest_service.repository;

import com.filatov.rest_service.entity.additionalclass.CityListFromTo;
import com.filatov.rest_service.utils.CalculateDistanceUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CalculateDistanceRepository {

    @PersistenceContext
    private EntityManager em;

    public StringBuilder calculateDistance(String calculateType, CityListFromTo cityListFromTo) {

        StringBuilder result = new StringBuilder();

        if (calculateType.equals("1")) {
            CalculateDistanceUtils.calculateDistanceCrowflight(cityListFromTo, result, em);

        } else if (calculateType.equals("2")) {
            CalculateDistanceUtils.calculateDistanceMatrix(cityListFromTo, result, em);

        } else if (calculateType.equals("3")) {
            CalculateDistanceUtils.calculateDistanceCrowflight(cityListFromTo, result, em);
            CalculateDistanceUtils.calculateDistanceMatrix(cityListFromTo, result, em);
        }
        return result;
    }
}
