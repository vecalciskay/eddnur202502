package persistencia;

import org.mapstruct.factory.Mappers;
import persistencia.accesodatos.dto.PersonaDTO;
import persistencia.mappers.PersonaMapper;
import persistencia.servicios.PersonaServicios;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class TestPersistencia {
    private static final PersonaMapper personaMapper = Mappers.getMapper(PersonaMapper.class);
    public static void main(String[] args) {
        System.out.println("Lista de personas");
        PersonaServicios servicio = new PersonaServicios();
        List<PersonaDTO> personas = servicio.getPersonas();
        for (PersonaDTO p: personas) {
            System.out.println(p);
        }

        System.out.println("---------------------------------");

        PersonaDTO p1 = new PersonaDTO();
        p1.setNombre("Paco");
        Calendar fecha = Calendar.getInstance();
        fecha.set(2001,5,3);
        p1.setFechaNacimiento(new Date(fecha.getTimeInMillis()));
        p1.setSalario(3454.4f);
        servicio.savePersona(p1);

        personas = servicio.getPersonas();
        for (PersonaDTO p: personas) {
            System.out.println(p);
        }

        System.out.println("---------------------------------");

        for (PersonaDTO p: personas) {
            if (p.getNombre().equals("Paco")) {
                servicio.deletePersona(p);
                break;
            }
        }

        personas = servicio.getPersonas();
        for (PersonaDTO p: personas) {
            System.out.println(p);
        }

        System.out.println("---------------------------------");

    }
}
