package com.homeservices.booking.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProviderProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String bio;
    @Column(nullable = false)
    private String experiencedYears;
    @Column(nullable = false)
    private double rating;
    @Column(nullable = false)
    private boolean is_available;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToMany(mappedBy = "providerProfile")
    private List<ProviderOffering> providerServiceList = new ArrayList<>();

    @OneToMany(mappedBy = "providerProfile")
    private List<Booking> bookings = new ArrayList<>();

    public ProviderProfile() {
    }

    public ProviderProfile(String name, String bio, String experiencedYears, double rating, boolean is_available) {
        this.bio = bio;
        this.name = name;
        this.experiencedYears = experiencedYears;
        this.rating = rating;
        this.is_available = is_available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getExperiencedYears() {
        return experiencedYears;
    }

    public void setExperiencedYears(String experiencedYears) {
        this.experiencedYears = experiencedYears;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProviderOffering> getProviderServiceList() {
        return providerServiceList;
    }

    public void setProviderServiceList(List<ProviderOffering> providerServiceList) {
        this.providerServiceList = providerServiceList;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
