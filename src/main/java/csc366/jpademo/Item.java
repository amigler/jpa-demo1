package csc366.jpademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;


@Entity
@Table (name="item")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="name")    
    private String name;

    @Column(name="cost")
    private double cost;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price", nullable = true)
    private double price;

    @Column(name="tax_rate", nullable = true)
    private double taxRate;

    @Column(name = "recipe", nullable = true)
    private String recipe;

    @Column(name = "is_ingredient")
    private Boolean isIngredient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="contract_id", nullable = true)
    private Contract contract;

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

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    } 

    public double getTaxRate(){
        return taxRate;
    }

    public void setTaxRate(double taxRate){
        this.taxRate = taxRate;
    }

    public String getRecipe(){
        return recipe;
    }

    public void setRecipe(String recipe){
        this.recipe = recipe;
    }

    public Boolean getIsIngredient(){
        return isIngredient;
    }

    public void setIsIngredient(Boolean isIngredient){
        this.isIngredient = isIngredient;
    }

    public Contract getContract(){
        return contract;
    }

    public void setContract(Contract contract){
        this.contract = contract;
    }

}
