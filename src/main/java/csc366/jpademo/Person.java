package csc366.jpademo;

import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table (name="Person")

public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="phoneNo")
    private String phoneNo;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="LastName")
    private String LastName;

    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="contract_id", nullable = true)
    
    @Column(name="RewardsOption", nullable = true)
    private Boolean RewardsOption;

    @Column(name="PaymentType", nullable = true)
    private String PaymentType;

    @Column(name="SSN", nullable = true)
    private int SSN;

    @Column(name="StoreId", nullable = true)
    private int StoreId;

    @Column(name="CompanyOwnings", nullable = true)
    private double CompanyOwnings;

    @Column(name="CompanyName", nullable = true)
    private String companyName;

    @Column(name="name", nullable = true)
    private String name;

    @Column(name="CountryofIncorperation", nullable = true)
    private String CountryofIncorperation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Boolean getRewardsOption() {
        return RewardsOption;
    }

    public void setRewardsOption(Boolean rewardsOption) {
        RewardsOption = rewardsOption;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int sSN) {
        SSN = sSN;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public double getCompanyOwnings() {
        return CompanyOwnings;
    }

    public void setCompanyOwnings(double companyOwnings) {
        CompanyOwnings = companyOwnings;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryofIncorperation() {
        return CountryofIncorperation;
    }

    public void setCountryofIncorperation(String countryofIncorperation) {
        CountryofIncorperation = countryofIncorperation;
    }




}
