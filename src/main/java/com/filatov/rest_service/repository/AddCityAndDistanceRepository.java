package com.filatov.rest_service.repository;

import com.filatov.rest_service.entity.City;
import com.filatov.rest_service.entity.additionalclass.CityAndDistanceLists;
import com.filatov.rest_service.entity.Distance;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Stateless
public class AddCityAndDistanceRepository {

    @PersistenceContext
    private EntityManager em;

    public void addCityAndDistanceLists(String list) throws JAXBException {

        StringReader reader = new StringReader(list);

        JAXBContext context = JAXBContext.newInstance(CityAndDistanceLists.class, City.class, Distance.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        CityAndDistanceLists cdl = (CityAndDistanceLists) unmarshaller.unmarshal(reader);

            for (City c : cdl.getCityList()) {
                em.persist(c);
            }

            for (Distance d : cdl.getDistanceList()) {
                em.persist(d);
            }
    }
}
