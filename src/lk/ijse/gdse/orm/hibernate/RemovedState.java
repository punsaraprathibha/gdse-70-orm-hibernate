package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class RemovedState {

    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer customer = session
                .get(Customer.class, 1); // Persistent State

        System.out.println(
                isExistsInSession(session, customer));

        session.delete(customer); // Removed State

        System.out.println(
                isExistsInSession(session, customer));

        session.close();
    }

    private static String isExistsInSession(Session session,
                                            Customer customer) {
        return session.contains(customer)
                ? "This object is in Persistent State"
                : "This object is in Removed State";
    }
}
