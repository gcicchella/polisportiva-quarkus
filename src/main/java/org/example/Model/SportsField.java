package org.example.Model;

import jakarta.persistence.*;

@Entity(name= "sports_field")
public class SportsField {

    @Id
    @Column(name = "id_sports_fields")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sport")
    private String sport;

    @Column(name = "is_indoor")
    private Boolean isIndoor;

    @Column(name = "soccer_field_type")
    private String soccerFieldType;

    @Column(name = "tennis_field_type")
    private String tennisFieldType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_price_list")
    private PriceList priceList;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_sports_facility")
    private SportsFacility sportsFacility;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Boolean getIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }

    public String getSoccerFieldType() {
        return soccerFieldType;
    }

    public void setSoccerFieldType(String soccerFieldType) {
        this.soccerFieldType = soccerFieldType;
    }

    public String getTennisFieldType() {
        return tennisFieldType;
    }

    public void setTennisFieldType(String tennisFieldType) {
        this.tennisFieldType = tennisFieldType;
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SportsFacility getSportsFacility() {
        return sportsFacility;
    }

    public void setSportsFacility(SportsFacility sportsFacility) {
        this.sportsFacility = sportsFacility;
    }
}