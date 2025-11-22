package persistencia.accesodatos.dao.factory;

import org.hibernate.Session;
import persistencia.accesodatos.dao.PersonaCommands;
import persistencia.accesodatos.dao.PersonaCommandsHibernateImpl;
import persistencia.accesodatos.dao.PersonaQueries;
import persistencia.accesodatos.dao.PersonaQueriesHibernateImpl;

public class HibernateDAOFactory extends DAOFactory {

    @Override
    public PersonaCommands getPersonaCommands(Session session) {
        return new PersonaCommandsHibernateImpl(session);
    }

    @Override
    public PersonaQueries getPersonaQueries(Session session) {
        return new PersonaQueriesHibernateImpl(session);
    }
}
