package eu.albertomorales.tddIntro.application.builder;

import java.io.Serializable;

public interface GenericBuilder<E, VO extends Serializable> {

    /**
     * Given a DTO, builds its entity.
     * @param  dto that contans entity attributes
     * @return Built entity.
     */
    E build(VO dto);

}
