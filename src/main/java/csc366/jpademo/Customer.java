package csc366.jpademo;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @Column(name = "RewardsOption")
    private boolean rewardsOption;

    @Column(name = "PaymentType")
    private String paymentType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    private Person person;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public Customer() {
    }

    public Customer(boolean rewardsOption, String paymentType, Person person) {
        this.rewardsOption = rewardsOption;
        this.paymentType = paymentType;
        this.person = person;
        this.customerID = person.getId();
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public boolean isRewardsOption() {
        return rewardsOption;
    }

    public void setRewardsOption(boolean rewardsOption) {
        this.rewardsOption = rewardsOption;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", Customer.class.getSimpleName() + "[", "]");
        sj.add(this.customerID.toString()).add(String.valueOf(this.rewardsOption)).add(this.paymentType);
        return sj.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return isRewardsOption() == customer.isRewardsOption() && Objects.equals(getCustomerID(),
                customer.getCustomerID()) && Objects.equals(getPaymentType(), customer.getPaymentType())
                && Objects.equals(person, customer.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerID(), isRewardsOption(), getPaymentType(), person);
    }
}
