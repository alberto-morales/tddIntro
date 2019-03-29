package eu.albertomorales.tddIntro.application.service;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import eu.albertomorales.tddIntro.application.builder.impl.PersonBuilder;
import eu.albertomorales.tddIntro.application.model.Person;
import eu.albertomorales.tddIntro.application.model.impl.PersonImpl;
import eu.albertomorales.tddIntro.application.persistency.GenericDAO;
import eu.albertomorales.tddIntro.application.service.impl.PersonServiceImpl;
import eu.albertomorales.tddIntro.application.view.PersonDTO;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.createNiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
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

    @DataProvider
    public static Object[][] operacionesConMocks_DP() {

        // setting up resources
        String nombre = "Alberto";
        String apellidos = "Morales";
        PersonDTO datosVista = new PersonDTO(nombre, apellidos);

        Person entidad = new PersonImpl();
        ((PersonImpl) entidad).setFirstName(nombre);
        ((PersonImpl) entidad).setLastName(apellidos);

        GenericDAO<Person, Integer> personDAOMock = createNiceMock(GenericDAO.class);

        PersonBuilder personBuilderMock = createNiceMock(PersonBuilder.class);

        EasyMock.expect(personBuilderMock.build(datosVista)).andReturn(entidad);
        EasyMock.replay(personBuilderMock); //activate the mock

        EasyMock.expect(personDAOMock.makePersistent(entidad)).andReturn(entidad);
        EasyMock.replay(personDAOMock); //activate the mock

        // setting up sut
        PersonServiceImpl sutConDependencias = new PersonServiceImpl();
        sutConDependencias.setPersonBuilder(personBuilderMock);
        sutConDependencias.setPersonDAO(personDAOMock);

        return new Object[][] {
                {nombre, apellidos, datosVista, entidad, personDAOMock, sutConDependencias}
        };
    }

    @Test
    @UseDataProvider("operacionesConMocks_DP")
    public void guardarTestPersistir(String nombre,
                                     String apellidos,
                                     PersonDTO datosVista,
                                     Person entidad,
                                     GenericDAO<Person, Integer> personDAO,
                                     PersonServiceImpl sut) {

        // test
        Person resultado = sut.guardar(datosVista);
        // assertions
        EasyMock.verify(personDAO); //verify call to calcService is made or not
    }

    @Test
    @UseDataProvider("operacionesConMocks_DP")
    public void guardarTestNoNulo(String nombre,
                                  String apellidos,
                                  PersonDTO datosVista,
                                  Person entidad,
                                  GenericDAO<Person, Integer> personDAO,
                                  PersonServiceImpl sut) {
        assertNotNull(sut.guardar(datosVista));
    }

    @Test
    @UseDataProvider("operacionesConMocks_DP")
    public void guardarTestNombreApellidos(String nombre,
                                           String apellidos,
                                           PersonDTO datosVista,
                                           Person entidad,
                                           GenericDAO<Person, Integer> personDAO,
                                           PersonServiceImpl sut) {
        Person resultado = sut.guardar(datosVista);
        assertEquals(nombre, resultado.getFirstName());
        assertEquals(apellidos, resultado.getLastName());
    }

}
