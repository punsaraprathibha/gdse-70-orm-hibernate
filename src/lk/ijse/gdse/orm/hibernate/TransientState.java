package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class TransientState {
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

        System.out.println(
                isExistsInSession(session, customer));
    }
    private static String isExistsInSession(Session session,
                                            Customer customer) {
        return session.contains(customer)
                ? "This object is not Transient"
                : "This object is in Transient State";
    }
}
