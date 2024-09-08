package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embedded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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
//        customer.setId(2); // Now it's not mandatory to set value to id
//        customer.setName("Kamal");

        NameIdentifier name = new NameIdentifier();
        name.setFirstName("Kamal");
        name.setMiddleName("De");
        name.setLastName("Silva");

        customer.setNameIdentifier(name);
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        customer.setAge(20);

        List<MobileNo> mobileNos = new ArrayList<>();

        MobileNo homeNo = new MobileNo();
        homeNo.setType("HOME");
        homeNo.setMobileNo("0913245467");


        customer.setPhoneNos();

        // 1. Save New Customer in DB
        Session session = SessionFactoryConfig
                .getInstance().getSession(); // Request new Session from Factory
        Transaction transaction = session.beginTransaction(); // Start Transaction
        session.save(customer);
        transaction.commit(); // Commit Transaction
        session.close(); // Close the Session

        // 2. Update existing customer in DB
        Session updateCusSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction updateCusTransaction = updateCusSession
                .beginTransaction();
//        customer.setName("Nimal");
        customer.setAddress("Mathara");
        customer.setSalary(50000);

        updateCusSession.update(customer);

        updateCusTransaction.commit();
        updateCusSession.close();

        // 3. Get Existing Customer from DB
        Session getCusSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Customer existingCustomer = getCusSession
                .get(Customer.class, 1);
        System.out.println(existingCustomer);

        // 4. Delete existing customer from DB
//        Session deleteCusSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction deleteCusTransaction = deleteCusSession
//                .beginTransaction();
//
//        deleteCusSession.delete(existingCustomer);
//
//        deleteCusTransaction.commit();
//        deleteCusSession.close();
    }
}