package com.filatov.rest_service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class Distance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1)
    private String fromCity;

    @NotNull
    @Size(min = 1)
    private String toCity;

    private String distance;

    public Distance() {
    }

    public long getId() {
        return id;
    }

    @XmlAttribute(name = "fromCity")
    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    @XmlAttribute(name = "toCity")
    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @XmlAttribute(name = "distance")
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
