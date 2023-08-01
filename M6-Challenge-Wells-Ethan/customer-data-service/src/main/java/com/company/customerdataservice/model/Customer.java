package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer implements Serializable {

    // columns

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "company")
    private String company;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;


    // getters/setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Customer customer = (Customer) object;
        return (getId() == customer.getId() && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getCompany(), customer.getCompany()) && Objects.equals(getPhone(), customer.getPhone()) && Objects.equals(getAddress1(), customer.getAddress1()) && Objects.equals(getAddress2(), customer.getAddress2()) && Objects.equals(getCity(), customer.getCity()) && Objects.equals(getState(), customer.getState()) && Objects.equals(getPostalCode(), customer.getPostalCode()) && Objects.equals(getCountry(), customer.getCountry()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone(), getAddress1(), getAddress2(), getCity(), getState(), getPostalCode(), getCountry());
    }

    @Override
    public String toString() {
        return String.format("Customer{" +
                        "customerId=%d, " +
                        "firstName='%s', " +
                        "lastName='%s', " +
                        "email='%s', " +
                        "company='%s', " +
                        "phone='%s', " +
                        "address1='%s', " +
                        "address2='%s', " +
                        "city='%s', " +
                        "state='%s', " +
                        "postalCode=%s, " +
                        "country='%s'}",
                id,
                firstName,
                lastName,
                email,
                company,
                phone,
                address1,
                address2,
                city,
                state,
                postalCode,
                country);
    }
}
