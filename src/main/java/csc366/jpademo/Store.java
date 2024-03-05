package csc366.jpademo;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "store_number")
    private int storeNumber;

    @Column(name= "city")
    private String city;

    @Column(name="State")
    private String state;

    @OneToMany(mappedBy = "store",       // join column should be in *Address*
               cascade = CascadeType.ALL, // all JPA actions (persist, remove, refresh, merge, detach) propagate to each address
               orphanRemoval = true,      // address records that are no longer attached to a person are removed
               fetch = FetchType.LAZY)
    private List<Contract> contracts = new ArrayList<>();


    @OneToMany(mappedBy = "store",       // join column should be in *Address*
            cascade = CascadeType.ALL, // all JPA actions (persist, remove, refresh, merge, detach) propagate to each address
            orphanRemoval = true,      // address records that are no longer attached to a person are removed
            fetch = FetchType.LAZY)
    private List<WorkScheduling> WorkSchedules = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "store",       // join column should be in *Address*
            cascade = CascadeType.ALL, // all JPA actions (persist, remove, refresh, merge, detach) propagate to each address
            orphanRemoval = true,      // address records that are no longer attached to a person are removed
            fetch = FetchType.LAZY)
    private List<CustomerOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "store",       // join column should be in *Address*
            cascade = CascadeType.ALL, // all JPA actions (persist, remove, refresh, merge, detach) propagate to each address
            orphanRemoval = true,      // address records that are no longer attached to a person are removed
            fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStoreNumber(){
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber){
        this.storeNumber = storeNumber;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public void addContract(Contract c) {
        contracts.add(c);
        c.setStore(this);
    }
    
    public void removeContract(Contract c) {
        contracts.remove(c);
        c.setStore(null);
    }
    
    public List<Contract> getContracts() {
        return this.contracts;
    }

    public void addWorkSchedule(WorkScheduling ws) {
        WorkSchedules.add(ws);
        ws.setStoreID(this);
    }
    
    public void removeWorkSchedule(WorkScheduling ws) {
        WorkSchedules.remove(ws);
        ws.setStoreID(null);
    }
    
    public List<WorkScheduling> getWorkSchedule() {
        return this.WorkSchedules;
    }

    
    public void addOrder(CustomerOrder order) {
        orders.add(order);
        order.setStore(this);
    }
    
    public void removeOrder(CustomerOrder order) {
        orders.remove(order);
        order.setStore(null);
    }
    
    public List<CustomerOrder> getCustomerOrders() {
        return this.orders;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        emp.setStore(this);
    }
    
    public void removeEmployee(Employee emp) {
        employees.remove(emp);
        emp.setStore(null);
    }
    
    public List<Employee> getEmployees() {
        return this.employees;
    }


    public Company getCompany(){
        return company;
    }

    public void setCompany(Company c){
        this.company = c;
    }




}
