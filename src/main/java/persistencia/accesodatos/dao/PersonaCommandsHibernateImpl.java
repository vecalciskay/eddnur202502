package persistencia.accesodatos.dao;

import org.hibernate.Session;
import persistencia.dominio.Persona;

public class PersonaCommandsHibernateImpl implements PersonaCommands {
    private final Session session; // Dependency injected by the DAOFactory

    public PersonaCommandsHibernateImpl(Session session) {
        this.session = session;
    }

    @Override
    public void save(Persona persona) {
        // Use the injected session to perform the persistence operation
        session.persist(persona);
    }

    @Override
    public void update(Persona persona) {
        session.merge(persona);
    }

    @Override
    public void delete(Persona persona) {
        session.remove(persona);
    }
}