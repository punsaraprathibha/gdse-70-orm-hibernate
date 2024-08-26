package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This is the session factory configuration class
 */
public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;

    /**
     * Defines default constructor as private
     * to avoid object creation of this class from outside
     */
    private SessionFactoryConfig(){}

    /**
     * @return lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig
     * Singleton the class to avoid object re-creation
     */
    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }

    /**
     * @return org.hibernate.Session
     * Returns Hibernate session whenever this method is called
     * by following the steps of Native Bootstrapping
     */
    public Session getSession() {
        // Step 1 - Create Service Registry
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                .configure()
                .build();

        // Step 2 - Create Metadata Object
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build();

        // Step 3 - Create SessionFactory Object
        SessionFactory sessionFactory = metadata
                .buildSessionFactory();

        return sessionFactory.openSession();
    }
}
