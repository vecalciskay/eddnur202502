package persistencia.accesodatos.dao;

import org.hibernate.Session;
import persistencia.dominio.Persona;

import java.util.List;

public class PersonaQueriesHibernateImpl implements PersonaQueries {

    private final Session session; // Injected by the DAOFactory

    public PersonaQueriesHibernateImpl(Session session) {
        this.session = session;
    }

    @Override
    public Persona findById(int id) {
        return session.find(Persona.class, id);
    }

    // Example of a custom query
    public List<Persona> findByNombre(String nombre) {
        // Use HQL (Hibernate Query Language) for finding multiple entities
        return session.createQuery(
                        "FROM Persona p WHERE p.nombre = :nombre", Persona.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    @Override
    public List<Persona> findTodos() {
        return session.createQuery(
            "FROM Persona p", Persona.class)
            .getResultList();
    }
}