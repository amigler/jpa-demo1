package csc366.jpademo;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity  // this class maps to a database table
public class PayStub {
    @Id
    private Date pay_period;   // note: no annotation, still included in underlying table
    private int hours;
    private int wage;
    private double fed_taxes;
    private double state_taxes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empl_id", nullable = true)
    private Person empl_id;
    
    public PayStub() { }
    
    public PayStub(Date pay_period, int hours, int wage, double fed_taxes, double state_taxes) {
	this.pay_period = pay_period;
	this.hours = hours;
	this.wage = wage;
	this.fed_taxes = fed_taxes;
    this.state_taxes = state_taxes;
    }
    
    public int getHours() {
	return hours;
    }
    public void setHours(int hours) {
	this.hours = hours;
    }

    public Date getpay_period() {
        return pay_period;
    }

    public void setpay_period(Date pay_period) {
        this.pay_period = pay_period;
    }

    public int getWage() {
	return wage;
    }
    public void setWage(int wage) {
	this.wage = wage;
    }

    public double getFed_Taxes() {
	return fed_taxes;
    }
    public void setFed_Taxes(double fed_taxes) {
	this.fed_taxes = fed_taxes;
    }
    public double getState_Taxes() {
    return state_taxes;
    }
    public void setState_Taxes(double state_taxes) {
    this.state_taxes = state_taxes;
    }

    public Person getEmpl_id() {
	return empl_id;
    }
    public void setEmpl_id(Person empl_id) {
	this.empl_id = empl_id;
    }
        
    @Override
    public String toString()
    {
	StringJoiner sj = new StringJoiner("," , PayStub.class.getSimpleName() + "[" , "]");
	sj.add(empl_id.toString()).add(pay_period.toString()).add(String.valueOf(wage)).add(String.valueOf(fed_taxes)).add(String.valueOf(state_taxes)).add(String.valueOf(hours));
	return sj.toString();
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) return true;
	if (!(o instanceof PayStub)) return false;
	return empl_id != null && empl_id.equals(((PayStub) o).getEmpl_id()) && pay_period != null && pay_period.equals(((PayStub) o).getpay_period());
    }

    @Override
    public int hashCode() {
	return 366;
    }
    
}
