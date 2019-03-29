package eu.albertomorales.tddIntro.application.builder.impl;

import eu.albertomorales.tddIntro.application.builder.GenericBuilder;
import eu.albertomorales.tddIntro.application.model.Person;
import eu.albertomorales.tddIntro.application.model.impl.PersonImpl;
import eu.albertomorales.tddIntro.application.view.PersonDTO;

public class PersonBuilder implements GenericBuilder<Person, PersonDTO> {

    @Override
    public Person build(PersonDTO dto) {
        Person result = new PersonImpl();
        ((PersonImpl) result).setFirstName(dto.getFirstName());
        ((PersonImpl) result).setLastName(dto.getLastName());
        return result;
    }
}
