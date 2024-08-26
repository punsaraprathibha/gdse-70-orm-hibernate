package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private SessionFactoryConfig(){}
    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }
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
        return metadata
                .buildSessionFactory().openSession();
    }
}
