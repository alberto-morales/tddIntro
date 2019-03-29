package eu.albertomorales.tddIntro.application.service;

import eu.albertomorales.tddIntro.application.model.Person;
import eu.albertomorales.tddIntro.application.view.PersonDTO;

public interface PersonService {

    /**
     * Persiste una persona, cuyos datos recibe como argumento
     *
     * @param datos de la persona
     *
     * @return Entidad (persona guardada)
     */
    public Person guardar(final PersonDTO datos);
}
