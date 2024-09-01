package lk.ijse.gdse.orm.hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// 1st Way -> @Entity(name = "customer")
// 2nd Way -> @Entity
//            @Table(name = "customer")
@Entity
@Table(name = "customer")
public class Customer {
    @Id // Tells hibernate that this is the primary key of this entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id") // defines how the column name should be generated in database
    private int id;
    @Column(name = "customer_name", nullable = false, length = 50)
    private String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_age", columnDefinition = "TINYINT")
    private int age;
    @CreationTimestamp
    private Timestamp createdDateTime;

    public Customer() {}

    public Customer(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
