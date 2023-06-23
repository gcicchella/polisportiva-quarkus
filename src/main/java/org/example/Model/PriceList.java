package org.example.Model;

import jakarta.persistence.*;

@Entity(name= "price_list")
public class PriceList {

    @Id
    @Column(name = "id_price_list")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price_per_hour")
    private Double pricePerHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
