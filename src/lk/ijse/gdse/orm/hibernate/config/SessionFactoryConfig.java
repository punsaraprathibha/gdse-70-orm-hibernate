package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.entity.Item;
import lk.ijse.gdse.orm.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This is the session factory configuration class
 */
public class SessionFactoryConfig {
    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    /**
     * Defines default constructor as private
     * to avoid object creation of this class from outside
     */
    private SessionFactoryConfig(){
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
    }

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
     */
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
