package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class EagerVsLazy {
    public static void main(String[] args) {

        Session saveSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer customer = new Customer();
        customer.setName("Kamal");
        customer.setAddress("Galle");

        saveSession.save(customer);
        saveSession.close();

        // 1. Get Method -
        Session getSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        System.out.println("-----------Calling Get Method-----------");
        Customer get = getSession.get(Customer.class, 1);
        System.out.println("Customer Id of Get: " + get.getId());
        System.out.println("Customer Name of Get: " + get.getName());
        getSession.close();

        // 2. Load Method -
        Session loadSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        System.out.println("-----------Calling Load Method-----------");
        Customer load = loadSession
                .load(Customer.class, 2);
        System.out.println("Customer Id of Load: "
                + load.getId());
        System.out.println("Customer Name of Load: "
                + load.getName());
        loadSession.close();
    }
}
