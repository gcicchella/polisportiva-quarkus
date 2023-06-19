package org.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name= "price_list")
public class PriceList {

    @Id
    @Column(name = "id_price_list")
    private String id;

    @Column(name = "price_per_hour")
    private Double pricePerHour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
