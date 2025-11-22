package persistencia.servicios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mapstruct.factory.Mappers;
import persistencia.accesodatos.dao.PersonaCommands;
import persistencia.accesodatos.dao.PersonaQueries;
import persistencia.accesodatos.dao.factory.DAOFactory;
import persistencia.accesodatos.ds.HibernateUtil;
import persistencia.accesodatos.dto.PersonaDTO;
import persistencia.dominio.Persona;
import persistencia.dominio.PersonaBuilder;
import persistencia.mappers.PersonaMapper;

import java.util.ArrayList;
import java.util.List;

public class PersonaServicios {
    private static final Logger logger = LogManager.getRootLogger();
    private final PersonaMapper personaMapper = Mappers.getMapper(PersonaMapper.class);

    public List<PersonaDTO> getPersonas() {
        Session session = HibernateUtil.getNewSession();
        PersonaQueries queries = DAOFactory.getFactory().getPersonaQueries(session);
        List<Persona> personas = queries.findTodos();
        List<PersonaDTO> resultado = new ArrayList<>();
        for(Persona p : personas) {
            resultado.add(personaMapper.toDTO(p));
        }
        return resultado;
    }

    public void deletePersona(PersonaDTO persona) {
        logger.info("Executing deletePersona command for ID: {}", persona.getId());

        Session session = HibernateUtil.getNewSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // 1. Call the Command layer, injecting the active Session
            PersonaBuilder constructor = new PersonaBuilder();
            Persona eliminarPersona = constructor.construir(
                    persona.getId(),
                    persona.getNombre(),
                    persona.getFechaNacimiento(),
                    persona.getSalario(),
                    persona.isHabilitado());
            DAOFactory.getFactory().getPersonaCommands(session).delete(eliminarPersona);

            tx.commit();
            logger.info("Transaction COMMITTED successfully for Persona deletion ID: {}", persona.getId());

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                logger.error("Transaction ROLLED BACK for Persona deletion ID: {}", persona.getId(), e);
            }
            // Translate persistence errors into service-level exceptions
            throw new RuntimeException("Could not delete persona.", e);
        } finally {
            session.close();
            logger.debug("Session closed after delete operation.");
        }
    }

    public void savePersona(PersonaDTO persona) {
        // 1. Log START of the command execution
        logger.info("Executing savePersona command for ID: {}", persona.getId());

        Session session = HibernateUtil.getNewSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            PersonaCommands dao = DAOFactory.getFactory().getPersonaCommands(session);
            PersonaBuilder constructor = new PersonaBuilder();

            Persona objPersona = constructor.construir(
                    persona.getId(),
                    persona.getNombre(),
                    persona.getFechaNacimiento(),
                    persona.getSalario(),
                    persona.isHabilitado());

            if (persona.getId() <= 0) {
                dao.save(objPersona);
                tx.commit();
                logger.info("Transaction COMMITTED successfully inserted Persona with ID: {}", persona.getId());
            }
            else {
                dao.update(objPersona);
                tx.commit();
                logger.info("Transaction COMMITTED successfully updated Persona ID: {}", persona.getId());
            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                // 3. Log FAILURE and ROLLBACK
                logger.error("Transaction ROLLED BACK for Persona ID: {}", persona.getId(), e);
            }
            // Translate technical errors and re-throw
            throw new RuntimeException("Could not save persona due to internal error.", e);
        } finally {
            session.close();
            logger.debug("Session closed for Persona ID: {}", persona.getId());
        }
    }
}
