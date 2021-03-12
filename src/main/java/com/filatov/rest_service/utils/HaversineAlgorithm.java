package com.filatov.rest_service.utils;

public class HaversineAlgorithm {

    private static final int EARTH_RADIUS = 6371;

    public static double distanceInKm(double startLati, double startLong, double endLati, double endLong) {

        double diffLati = Math.toRadians(endLati - startLati);
        double diffLong = Math.toRadians(endLong - startLong);

        double radiusStartLati = Math.toRadians(startLati);
        double radiusEndLati = Math.toRadians(endLati);

        double a = Math.pow(Math.sin(diffLati / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * Math.cos(radiusStartLati) * Math.cos(radiusEndLati);
        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS * c;
    }

}
