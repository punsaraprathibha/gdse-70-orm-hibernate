package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This is the Main class of this Hibernate Application
 */
public class Main {

    /**
     * @param args : java.lang.String[]
     * Main method of this Application
     */
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        // Save New Customer in DB
//        Session session = SessionFactoryConfig
//                .getInstance().getSession(); // Request new Session from Factory
//        Transaction transaction = session.beginTransaction(); // Start Transaction
//        session.save(customer);
//        transaction.commit(); // Commit Transaction
//        session.close(); // Close the Session

        // Update existing customer in DB
        Session updateCusSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction updateCusTransaction = updateCusSession
                .beginTransaction();
        customer.setName("Nimal");
        customer.setAddress("Mathara");
        customer.setSalary(50000);

        updateCusSession.update(customer);

        updateCusTransaction.commit();
        updateCusSession.close();
    }
}