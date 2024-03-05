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
import javax.persistence.OrderColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity  // indicates that this class maps to a database table
@Table(
    name = "company"
)
public class Company {
    @NotNull
    @Column(unique=true, name="name")
    private String name;
    
    @Column(name="country")
    private String country;

    @OneToMany(mappedBy = "company",       // join column should be in *Owner*
               orphanRemoval = true,      // owner records that are no longer attached to a company are removed
               fetch = FetchType.LAZY)
    private List<Owner> owners = new ArrayList<>();

    @OneToMany(mappedBy = "company",       // join column should be in *Store*
               orphanRemoval = true,      // store records that are no longer attached to a company are removed
               fetch = FetchType.LAZY)
    private List<Store> stores = new ArrayList<>();
    
    public Company() { }
    
    public Company(String name, String country) {
	this.name = name;
	this.country = country;
    }
    
    public String getName() {
	return this.name;
    }
    public void setName(String name) {
	this.name = name;
    }

    public String getCountry() {
	return this.country;
    }
    public void setCountry(String country) {
	this.name = country;
    }
    
    @Override
    public int hashCode() {
	return 366;
    }
    
}