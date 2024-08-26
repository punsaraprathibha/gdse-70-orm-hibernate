package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction transaction = session
                .beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }
}