package persistencia.servicios;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mapstruct.factory.Mappers;
import persistencia.accesodatos.dao.PersonaCommands;
import persistencia.accesodatos.dao.factory.DAOFactory;
import persistencia.accesodatos.ds.HibernateUtil;
import persistencia.accesodatos.dto.PersonaDTO;
import persistencia.dominio.Persona;
import persistencia.dominio.PersonaBuilder;
import persistencia.mappers.PersonaMapper;

public class InscripcionesServicio {
    private final PersonaMapper personaMapper = Mappers.getMapper(PersonaMapper.class);
    public void inscribirPersona(PersonaDTO persona, String materia) {

        Session session = HibernateUtil.getNewSession(); // Get new Session for this Unit of Work
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // START the atomic operation

            // 1. Save persona
            PersonaBuilder constructor = new PersonaBuilder();

            Persona objPersona = constructor.construir(
                    persona.getId(),
                    persona.getNombre(),
                    persona.getFechaNacimiento(),
                    persona.getSalario(),
                    persona.isHabilitado());
            DAOFactory factory = DAOFactory.getFactory();
            PersonaCommands commands = factory.getPersonaCommands(session);
            commands.save(objPersona);

            // 2. inscribir la persona
            //new ProductCommandsImpl(session).decreaseStock(order.getProductId(), quantity);

            tx.commit(); // COMMIT if ALL commands succeeded

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // ROLLBACK if ANY command failed
            }
            // Log error and re-throw exception to client
            throw new RuntimeException("Transaction failed: All changes reverted.", e);
        } finally {
            session.close(); // ALWAYS close the Session
        }
    }
}