package persistencia.accesodatos.dao.factory;

import org.hibernate.Session;
import persistencia.accesodatos.dao.PersonaCommands;
import persistencia.accesodatos.dao.PersonaQueries;

public abstract class DAOFactory {
    public static DAOFactory getFactory() {
        return new HibernateDAOFactory();
    }
    public abstract PersonaCommands getPersonaCommands(Session session);
    public abstract PersonaQueries getPersonaQueries(Session session);
}
