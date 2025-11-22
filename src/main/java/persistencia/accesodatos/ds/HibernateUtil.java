package persistencia.accesodatos.ds;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import persistencia.dominio.Persona;

public class HibernateUtil {
    // 1. Static field to hold the single SessionFactory instance
    private static SessionFactory sessionFactory;

    // 2. Private constructor to prevent direct instantiation
    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create Configuration
            Configuration configuration = new Configuration();

            // 1. Load the hibernate.cfg.xml file
            configuration.configure("hibernate.cfg.xml");

            // 2. Register your persistent classes (entities)
            configuration.addAnnotatedClass(Persona.class);
            // configuration.addAnnotatedClass(Product.class); // e.g.

            // 3. Create the ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getNewSession() {
        if (sessionFactory == null) {
            // Logic to build the SessionFactory and configure MySQL goes here
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
