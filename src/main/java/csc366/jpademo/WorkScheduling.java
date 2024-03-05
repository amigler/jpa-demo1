package csc366.jpademo;

import java.util.List;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OrderColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity  // indicates that this class maps to a database table
@Table(
    name = "work_scheduling"
)
public class WorkScheduling {
    
    @NotNull
    @Column(name="start_time")
    private Date start_time;

    @NotNull
    @Column(name="end_time")
    private Date end_time;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
    
    public WorkScheduling() { }
    
    public WorkScheduling(Employee employee, Date start_time, Date end_time, Store store) {
	this.employee = employee;
    this.start_time = start_time;
    this.end_time = end_time;
    this.store = store;
    }

    public Employee getEmp() {
	return this.employee;
    }
    public void setEmpID(Employee emp) {
	this.employee = emp;
    }
    
    public Date getStartTime() {
	return this.start_time;
    }
    public void setStartTime(Date start) {
	this.start_time = start;
    }

    public Date getEndTime() {
	return this.end_time;
    }
    public void setEndTime(Date end) {
	this.end_time = end;
    }

    public Store getStoreID() {
	return this.store;
    }
    public void setStoreID(Store store) {
	this.store = store;
    }

    @Override
    public int hashCode() {
	return 366;
    }
    
}