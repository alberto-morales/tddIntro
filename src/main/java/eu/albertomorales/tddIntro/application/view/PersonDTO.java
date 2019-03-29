package eu.albertomorales.tddIntro.application.view;

import java.io.Serializable;

public class PersonDTO implements Serializable {


    public PersonDTO(String firstName, String lsstName) {
        this.firstName = firstName;
        this.lsstName = lsstName;
    }

    /**
     * @return Person firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Person lastName
     */
    public String getLastName() {
        return lsstName;
    }

    private String firstName;
    private String lsstName;
}
