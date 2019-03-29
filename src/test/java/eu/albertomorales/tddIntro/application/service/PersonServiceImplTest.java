package eu.albertomorales.tddIntro.application.service;

import eu.albertomorales.tddIntro.application.builder.impl.PersonBuilder;
import eu.albertomorales.tddIntro.application.model.Person;
import eu.albertomorales.tddIntro.application.model.impl.PersonImpl;
import eu.albertomorales.tddIntro.application.persistency.GenericDAO;
import eu.albertomorales.tddIntro.application.service.impl.PersonServiceImpl;
import eu.albertomorales.tddIntro.application.view.PersonDTO;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class PersonServiceImplTest {

    @Before
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(expected = IllegalArgumentException.class)
    public void guardarArgumentoNulo() {
        PersonServiceImpl sut = new PersonServiceImpl();
        sut.guardar(null);
    }

    @Test
    public void guardarTestNoNulo() {
        PersonServiceImpl sut = new PersonServiceImpl();
        assertNotNull(sut.guardar(new PersonDTO(null,null)));
    }

    @Test
    public void guardarTestNombreApellidos() {
        String nombre = "Alberto";
        String apellidos = "Morales";
        PersonServiceImpl sut = new PersonServiceImpl();
        Person resultado = sut.guardar(new PersonDTO(nombre, apellidos));
        assertEquals(nombre, resultado.getFirstName());
        assertEquals(apellidos, resultado.getLastName());
    }

    @Mock
    GenericDAO<Person, Integer> personDAO;

    @Mock
    PersonBuilder personBuilder;

    @TestSubject
    PersonServiceImpl sutParaPersistir = new PersonServiceImpl();

    @Test
    public void guardarTestPersistir() {
        // setting up resources
        String nombre = "Alberto";
        String apellidos = "Morales";
        PersonDTO datosVista = new PersonDTO(nombre, apellidos);

        Person entidad = new PersonImpl();
        ((PersonImpl) entidad).setFirstName(nombre);
        ((PersonImpl) entidad).setLastName(apellidos);
        EasyMock.expect(personBuilder.build(datosVista)).andReturn(entidad);
        EasyMock.replay(personBuilder); //activate the mock

        EasyMock.expect(personDAO.makePersistent(entidad)).andReturn(entidad);
        EasyMock.replay(personDAO); //activate the mock

        // setting up sut
        PersonServiceImpl sut = sutParaPersistir;

        // test
        Person resultado = sut.guardar(datosVista);
        // assertins
        assertEquals(nombre, resultado.getFirstName());
        assertEquals(apellidos, resultado.getLastName());

        EasyMock.verify(personDAO); //verify call to calcService is made or not
    }

}
