package csc366.jpademo;

import csc366.jpademo.Customer;
import csc366.jpademo.CustomerOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class CustomerTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

//    @BeforeEach
//    public void setUp() {
//        // Initialize EntityManagerFactory and EntityManager
//        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-name");
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @Test
//    public void testCreateCustomerAndOrder() {
//        // Test the creation of Customer and CustomerOrder instances
//        Customer customer = new Customer(true, "Credit", new Person(/* provide necessary data */));
//        CustomerOrder order = new CustomerOrder(customer, new Store(/* provide necessary data */),
//                new Date(), 100.0, "Credit");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(customer);
//        entityManager.persist(order);
//        entityManager.getTransaction().commit();
//
//        // Assertions to verify the state of the database
//        assertNotNull(customer.getCustomerID());
//        assertNotNull(order.getOrderID());
//        assertEquals(1, customer.getCustomerOrders().size());
//        assertEquals(customer, order.getCustomer());
//    }
//
//    @Test
//    public void testUpdateCustomer() {
//        // Test updating Customer information
//        Customer customer = new Customer(true, "Credit", new Person(/* provide necessary data */));
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(customer);
//        entityManager.getTransaction().commit();
//
//        // Modify and update customer information
//        entityManager.getTransaction().begin();
//        customer.setRewardsOption(false);
//        customer.setPaymentType("Debit");
//        entityManager.getTransaction().commit();
//
//        // Retrieve customer from the database and verify changes
//        Customer updatedCustomer = entityManager.find(Customer.class, customer.getCustomerID());
//        assertFalse(updatedCustomer.isRewardsOption());
//        assertEquals("Debit", updatedCustomer.getPaymentType());
//    }
//
//    @Test
//    public void testDeleteCustomerOrder() {
//        // Test deleting a CustomerOrder
//        Customer customer = new Customer(true, "Credit", new Person(/* provide necessary data */));
//        CustomerOrder order = new CustomerOrder(customer, new Store(/* provide necessary data */),
//                new Date(), 100.0, "Credit");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(customer);
//        entityManager.persist(order);
//        entityManager.getTransaction().commit();
//
//        // Delete the order and verify it is removed from the customer's orders
//        entityManager.getTransaction().begin();
//        entityManager.remove(order);
//        entityManager.getTransaction().commit();
//
//        entityManager.clear(); // Ensure the EntityManager is cleared to fetch fresh data
//        Customer updatedCustomer = entityManager.find(Customer.class, customer.getCustomerID());
//        assertEquals(0, updatedCustomer.getCustomerOrders().size());
//    }
//
//    @Test
//    public void testFindByPaymentType() {
//        // Test a query to find CustomerOrders by payment type
//        Customer customer = new Customer(true, "Credit", new Person(/* provide necessary data */));
//        CustomerOrder order1 = new CustomerOrder(customer, new Store(/* provide necessary data */),
//                new Date(), 100.0, "Credit");
//        CustomerOrder order2 = new CustomerOrder(customer, new Store(/* provide necessary data */),
//                new Date(), 150.0, "Debit");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(customer);
//        entityManager.persist(order1);
//        entityManager.persist(order2);
//        entityManager.getTransaction().commit();
//
//        // Query to find orders by payment type
//        List<CustomerOrder> creditOrders = entityManager.createQuery(
//                        "SELECT o FROM CustomerOrder o WHERE o.paymentType = 'Credit'", CustomerOrder.class)
//                .getResultList();
//
//        assertEquals(1, creditOrders.size());
//        assertEquals(order1.getOrderID(), creditOrders.get(0).getOrderID());
//    }
//
//    // Add more test methods for other scenarios
//
//    @AfterEach
//    public void tearDown() {
//        // Teardown and cleanup
//        // This could involve rolling back transactions, closing the EntityManager, etc.
//        entityManager.close();
//        entityManagerFactory.close();
//    }
}
