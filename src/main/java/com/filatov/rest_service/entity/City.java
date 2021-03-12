package com.filatov.rest_service.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(unique = true)
    private String name;

    @NotNull
    @Range(min=-180,max=180)
    private double latitude;

    @NotNull
    @Range(min=-180,max=180)
    private double longtitude;

    public City() {
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @XmlAttribute(name = "longtitude")
    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Latitude='" + latitude + '\'' +
                ", Longtitude='" + longtitude + '\'' +
                '}';
    }

}