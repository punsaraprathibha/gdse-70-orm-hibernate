//package lk.ijse.gdse.orm.hibernate.entity;
//
//import lk.ijse.gdse.orm.hibernate.embedded.MobileNo;
//import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//// 1st Way -> @Entity(name = "customer")
//// 2nd Way -> @Entity
////            @Table(name = "customer")
//@Entity
//@Table(name = "customer")
//public class Customer {
//    @Id // Tells hibernate that this is the primary key of this entity
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id") // defines how the column name should be generated in database
//    private int id;
////    @Column(name = "customer_name", nullable = false, length = 50)
////    private String name;
//    private NameIdentifier nameIdentifier;
//
//    @Column(name = "customer_address")
//    private String address;
//    @Column(name = "customer_salary")
//    private double salary;
//
//    @Column(name = "customer_age", columnDefinition = "TINYINT")
//    private int age;
//    @CreationTimestamp
//    private Timestamp createdDateTime;
//
//    @Transient
//    @Column(name = "customer_dob")
//    private String dob;
//
//    @ElementCollection
//    @CollectionTable(name = "customer_mobile_nos",
//                     joinColumns =
//                     @JoinColumn(name = "customer_id"))
//    private List<MobileNo> phoneNos
//            = new ArrayList<>();
//
//    public List<MobileNo> getPhoneNos() {
//        return phoneNos;
//    }
//
//    public void setPhoneNos(List<MobileNo> phoneNos) {
//        this.phoneNos = phoneNos;
//    }
//
//    public Customer() {}
//
//    public Customer(int id, NameIdentifier nameIdentifier, String address, double salary, int age, Timestamp createdDateTime, String dob) {
//        this.id = id;
//        this.nameIdentifier = nameIdentifier;
//        this.address = address;
//        this.salary = salary;
//        this.age = age;
//        this.createdDateTime = createdDateTime;
//        this.dob = dob;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public NameIdentifier getNameIdentifier() {
//        return nameIdentifier;
//    }
//
//    public void setNameIdentifier(NameIdentifier nameIdentifier) {
//        this.nameIdentifier = nameIdentifier;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Timestamp getCreatedDateTime() {
//        return createdDateTime;
//    }
//
//    public void setCreatedDateTime(Timestamp createdDateTime) {
//        this.createdDateTime = createdDateTime;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", nameIdentifier=" + nameIdentifier +
//                ", address='" + address + '\'' +
//                ", salary=" + salary +
//                ", age=" + age +
//                ", createdDateTime=" + createdDateTime +
//                ", dob='" + dob + '\'' +
//                '}';
//    }
//}
