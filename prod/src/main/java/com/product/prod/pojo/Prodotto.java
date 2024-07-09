package com.product.prod.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50,
    nullable = false,
    unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    private double price;
    private int rebate; // sconto percentuale
    private int quantity;
    private String condit;

    public Prodotto() {

    }

    public Prodotto
    (String name,
    String description,
    double price,
    int rebate,
    int quantity,
    String condit) throws Exception {

        setName(name);
        setDescription(description);
        setPrice(price);
        setRebate(rebate);
        setQuantity(quantity);
        setCondit(condit);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws Exception {

        if (price <= 0.0) {
            throw new Exception("Price should be greater than 0.0");
        }

        this.price = price;
    }
    public int getRebate() {
        return rebate;
    }
    public void setRebate(int rebate) throws Exception {

        if (rebate < 0) {
            throw new Exception("Rebate should be greater than 0 or 0");
        }

        this.rebate = rebate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) throws Exception {
        
        if (quantity < 0) {
            throw new Exception("Quantity can't be less then 0");
        }
        this.quantity = quantity;
    }
    public String getCondit() {
        return condit;
    }
    public void setCondit(String condit) {
        this.condit = condit;
    }

    public double getFinalPrice() {

        double rebate = getPrice() * (getRebate() / 100);
        return getPrice() - rebate;
    }

    @Override
    public String toString() {
        return getName() + " "
        + getDescription() + " "
        + getFinalPrice() + " euro "
        + getQuantity() + " unità "
        + getRebate() + "% "
        + getCondit();
    }
}
