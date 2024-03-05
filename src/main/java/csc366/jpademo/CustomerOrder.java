package csc366.jpademo;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CustomerOrder")
public class CustomerOrder {

    @Id
    @Column(name = "OrderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @OneToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customer customer;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
//    @JoinColumn(name = "StoreID", referencedColumnName = "ID")
//    private Store store;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "TotalAmount")
    private double totalAmount;

    @Column(name = "PaymentType")
    private String paymentType;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer, /*Store store,*/ Date orderDate, double totalAmount, String paymentType) {
        this.customer = customer;
//        this.store = store;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Store getStore() {
//        return store;
//    }
//
//    public void setStore(Store store) {
//        this.store = store;
//    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrder)) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Double.compare(getTotalAmount(), that.getTotalAmount()) == 0 && Objects.equals(getOrderID(),
                that.getOrderID()) && Objects.equals(getCustomer(), that.getCustomer()) &&
                /*Objects.equals(store, that.store) &&*/ Objects.equals(getOrderDate(), that.getOrderDate()) &&
                Objects.equals(getPaymentType(), that.getPaymentType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getCustomer(), /*store,*/ getOrderDate(), getTotalAmount(), getPaymentType());
    }
}
