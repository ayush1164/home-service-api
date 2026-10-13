package com.homeservices.booking.entity;

import com.homeservices.booking.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
A booking essentially says:
Customer X booked Service Y from Provider Z.

User (Customer)
      │
      │
      ▼
   Booking
    │   │
    │   └──────────► ProviderProfile
    │
    └──────────────► ServiceOffering
 */

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalTime scheduledTime;
    @Column(nullable = false)
    private LocalDate scheduledDate;
    @Column(nullable = false)
    private LocalDateTime bookingDate;
    private double totalAmount;
    @Column(nullable = true)
    private String clientNotes;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ProviderProfile providerProfile;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceOffering service;

    public Booking() {
    }

    public Booking(LocalTime scheduledTime, LocalDate scheduledDate, LocalDateTime bookingDate, double totalAmount, String clientNotes, Status status) {
        this.scheduledTime = scheduledTime;
        this.scheduledDate = scheduledDate;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.clientNotes = clientNotes;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(String clientNotes) {
        this.clientNotes = clientNotes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProviderProfile getProviderProfile() {
        return providerProfile;
    }

    public void setProviderProfile(ProviderProfile providerProfile) {
        this.providerProfile = providerProfile;
    }

    public ServiceOffering getService() {
        return service;
    }

    public void setService(ServiceOffering service) {
        this.service = service;
    }
}
