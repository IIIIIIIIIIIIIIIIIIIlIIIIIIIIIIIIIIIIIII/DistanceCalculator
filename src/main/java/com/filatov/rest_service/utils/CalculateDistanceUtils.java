package com.filatov.rest_service.utils;

import com.filatov.rest_service.entity.City;
import com.filatov.rest_service.entity.additionalclass.CityListFromTo;
import com.filatov.rest_service.entity.Distance;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CalculateDistanceUtils {

    public static StringBuilder calculateDistanceCrowflight(CityListFromTo cityListFromTo, StringBuilder result, EntityManager em) {
        result.append("Calculation Type: Crowflight\n");
        for (int i = 0; i < cityListFromTo.getCityListFrom().size(); i++) {

            String nameCityFrom = cityListFromTo.getCityListFrom().get(i);
            String nameCityTo = cityListFromTo.getCityListTo().get(i);

            try {
                City cityFrom = (City) em.createQuery("SELECT city FROM City city WHERE city.name = :nameCityFrom")
                        .setParameter("nameCityFrom", nameCityFrom)
                        .getSingleResult();

                City cityTo = (City) em.createQuery("SELECT city FROM City city WHERE city.name = :nameCityTo")
                        .setParameter("nameCityTo", nameCityTo)
                        .getSingleResult();

                double distance = HaversineAlgorithm.distanceInKm(cityFrom.getLatitude(), cityFrom.getLongtitude(),
                        cityTo.getLatitude(), cityTo.getLongtitude());

                result.append("From " + nameCityFrom + " to " + nameCityTo + " distance = " + distance + "\n");
            } catch (NoResultException nre) {
                result.append("Нет дистанции для " + nameCityFrom + " и " + nameCityTo + "\n");
            }
        }
        return result;
    }

    public static StringBuilder calculateDistanceMatrix(CityListFromTo cityListFromTo, StringBuilder result, EntityManager em) {
        result.append("Calculation Type: Distance Matrix\n");
        for (int i = 0; i < cityListFromTo.getCityListFrom().size(); i++) {

            String nameCityFrom = cityListFromTo.getCityListFrom().get(i);
            String nameCityTo = cityListFromTo.getCityListTo().get(i);

            try {
                Distance distance = (Distance) em.createQuery("SELECT distance FROM Distance distance WHERE " +
                        "(distance.fromCity = :nameCityFrom AND distance.toCity = :nameCityTo) OR " +
                        "(distance.fromCity = :nameCityTo AND distance.toCity = :nameCityFrom)")
                        .setParameter("nameCityFrom", nameCityFrom).setParameter("nameCityTo", nameCityTo)
                        .getSingleResult();

                result.append("From " + nameCityFrom + " to " + nameCityTo + " distance = " + distance.getDistance() + "\n");
            } catch (NoResultException nre) {
                result.append("Нет дистанции для " + nameCityFrom + " и " + nameCityTo + "\n");
            }
        }
        return result;
    }
}
