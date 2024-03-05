package csc366.jpademo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;


@Entity
@Table (name="contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_manager_id")
    private LocationManager lm;

    public Contract() {}
    public Contract(Supplier supplier, Store store, Item item){
        this.supplier = supplier;
        this.store = store;
        this.item = item;
    }

    public long getId(){
        return this.id;
        
    }

    public Supplier getSupplier(){
        return this.supplier;
    }

    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }

    public Store getStore(){
        return this.store;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public LocationManager getlocationManager(){
        return this.LocationManager;
    }

    public void setItem(LocationManager lm){
        this.LocationManager = lm;
    }

        
}
