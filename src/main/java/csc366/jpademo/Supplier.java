package csc366.jpademo;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity  // indicates that this class maps to a database table
@Table(
    name = "supplier"     // may be omitted for default table naming
     // uniqueConstraints = @UniqueConstraint(columnNames={"last_name", "first_name"}) // requires @Column(name=...) 
)
public class Supplier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(unique=true, name="address")
    private String address;

    
    @Column(unique=true, name="phone_number")
    private int phoneNumber;


    @OneToMany(mappedBy = "supplier",       // join column should be in *Address*
               cascade = CascadeType.ALL, // all JPA actions (persist, remove, refresh, merge, detach) propagate to each address
               orphanRemoval = true,      // address records that are no longer attached to a person are removed
               fetch = FetchType.LAZY)
    //@OrderColumn(name = "list_idx")
    private List<Contract> contracts = new ArrayList<>();
    
    public Supplier() {}
    
    public Supplier(String name,  String address, int phoneNumber) {
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
    }
    
    public Long getId() {
	return id;
    }
    public void setId(Long id) {
	this.id = id;
    }
    
    public String getName() {
	return name;
    }
    public void setName(String firstName) {
	this.name = firstName;
    }

    public String getAdress() {
	return address;
    }
    public void setAddress(String adress) {
	this.address = adress;
    }

    public void addContract(Contract c) {
    contracts.add(c);
    c.setSupplier(this);
    }

    public void removeContract(Contract c) {
    contracts.remove(c);
    c.setSupplier(null);
    }

    public List<Contract> getContracts() {
    return this.contracts;
    }
    
    // @Override
    // public String toString() {
	// StringJoiner sj = new StringJoiner("," , Person.class.getSimpleName() + "[" , "]");
	// sj.add(id.toString()).add(name).add(name).add("contracts="+contracts.toString());
	// return sj.toString();
    // }

    @Override
    public int hashCode() {
	return 366;
    }
    
}