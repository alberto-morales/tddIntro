package eu.albertomorales.tddIntro.application.service.impl;

import eu.albertomorales.tddIntro.application.model.Person;
import eu.albertomorales.tddIntro.application.model.impl.PersonImpl;
import eu.albertomorales.tddIntro.application.view.PersonDTO;
import eu.albertomorales.tddIntro.application.service.PersonService;
import eu.albertomorales.tddIntro.application.builder.impl.PersonBuilder;
import eu.albertomorales.tddIntro.application.persistency.GenericDAO;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person guardar(final PersonDTO datos) {
        if (datos == null) throw new IllegalArgumentException();

        Person result = personBuilder.build(datos);

        personDAO.makePersistent(result);

        return result;
    }

    public void setPersonBuilder(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public void setPersonDAO(GenericDAO<Person, Integer> personDAO) {
        this.personDAO = personDAO;
    }

    private PersonBuilder personBuilder;
    private GenericDAO<Person, Integer> personDAO;

}
