package com.filatov.rest_service.entity.additionalclass;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "root")
public class CityListFromTo implements Serializable {

    @XmlElementWrapper(name="citiesListFrom", nillable = true)
    List<String> cityListFrom = new ArrayList<>();

    @XmlElementWrapper(name="citiesListTo", nillable = true)
    List<String> cityListTo = new ArrayList<>();

    public List<String> getCityListFrom () {
        return cityListFrom;
    }

    public List<String> getCityListTo () {
        return cityListTo;
    }
}
