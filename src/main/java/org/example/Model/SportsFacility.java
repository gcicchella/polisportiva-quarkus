package org.example.Model;

import jakarta.persistence.*;

@Entity(name= "sports_facility")
public class SportsFacility {

    @Id
    @Column(name = "id_sports_facility")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "total_sports_fields")
    private Integer totalSportsFields;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTotalSportsFields() {
        return totalSportsFields;
    }

    public void setTotalSportsFields(Integer totalSportsFields) {
        this.totalSportsFields = totalSportsFields;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}