package org.example.Model;

import jakarta.persistence.*;
import org.example.Altro.Enumeration.ReservationStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity(name= "reservation")
public class Reservation {

    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "startDateTime")
    private ZonedDateTime startDateTime;

    @Column(name = "endDateTime")
    private ZonedDateTime endDateTime;

    @Column(name = "createdAt")
    private ZonedDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ReservationStatus state;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_sports_fields")
    private SportsField sportsField;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ReservationRating> reservationRatings = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ReservationStatus getState() {
        return state;
    }

    public void setState(ReservationStatus state) {
        this.state = state;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SportsField getSportsField() {
        return sportsField;
    }

    public void setSportsField(SportsField sportsField) {
        this.sportsField = sportsField;
    }
}
