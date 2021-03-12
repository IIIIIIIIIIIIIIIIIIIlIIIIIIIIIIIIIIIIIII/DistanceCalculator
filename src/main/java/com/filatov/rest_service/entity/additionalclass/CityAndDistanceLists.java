package com.filatov.rest_service.entity.additionalclass;

import com.filatov.rest_service.entity.City;
import com.filatov.rest_service.entity.Distance;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "root")
public class CityAndDistanceLists implements Serializable {

    @XmlElementWrapper(name="cities", nillable = true)
    List<City> cityList = new ArrayList<>();

    @XmlElementWrapper(name="distances", nillable = true)
    List<Distance> distanceList = new ArrayList<>();

    public List<City> getCityList () {
        return cityList;
    }

    public List<Distance> getDistanceList () {
        return distanceList;
    }
}
