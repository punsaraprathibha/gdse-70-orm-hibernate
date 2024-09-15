package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DetachedState {
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
                isExistsInSession(session, customer)); // Persistent State
        session.close();

        Session detatchSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction transaction = detatchSession
                .beginTransaction();

        detatchSession.detach(customer); // Detached State

        System.out.println(
                isExistsInSession(detatchSession, customer)); // Detached State

        customer.setAddress("Matara");
        detatchSession.merge(customer);// Persistent state

        System.out.println(
                isExistsInSession(detatchSession, customer));

        transaction.commit();
        detatchSession.close();
    }

    private static String isExistsInSession(Session session,
                                            Customer customer) {
        return session.contains(customer)
                ? "This object is in Persistent State"
                : "This object is in Detached State";
    }
}
