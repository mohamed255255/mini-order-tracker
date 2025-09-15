package com.example.demo.Model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders") 
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @NotNull
    private Double price;
    @NotNull
    private String status;
   
    @NotNull
    private int total_amount;

    /// cascade happens at the parent part of the relation , what happen to the child when the parent is affected
    @OneToMany(mappedBy = "order" , cascade = jakarta.persistence.CascadeType.PERSIST)
    private List<Payment> payments ;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getTotal_amount() {
        return total_amount;
    }


}
