package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class PersistentState {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        // Now this object is in Transient State
        Customer customer = new Customer(
                1,
                "Saman",
                "Galle",
                new ArrayList<>());

        int cusId = (int) session.save(customer); // Persistent State
        System.out.println("Customer Id: " + cusId);

        System.out.println(
                isExistsInSession(session, customer));
        session.close();
    }

    private static String isExistsInSession(Session session,
                                            Customer customer) {
        return session.contains(customer)
                ? "This object is in Persistent State"
                : "This object is in Transient State";
    }
}
