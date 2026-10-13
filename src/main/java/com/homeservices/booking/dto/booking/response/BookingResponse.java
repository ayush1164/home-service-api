package com.homeservices.booking.dto.booking.response;

import com.homeservices.booking.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookingResponse {

    private Long id;

    private Long userId;
    private String userName;

    private Long serviceId;
    private String serviceName;

    private Long providerId;
    private String providerName;

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;
    private LocalDateTime bookingDate;

    private double totalAmount;
    private String clientNotes;
    private Status status;

    public BookingResponse() {
    }

    public BookingResponse(Long id, Long userId, String userName, Long serviceId, String serviceName, Long providerId, String providerName, LocalDate scheduledDate, LocalTime scheduledTime, LocalDateTime bookingDate, double totalAmount, String clientNotes, Status status) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.providerId = providerId;
        this.providerName = providerName;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.clientNotes = clientNotes;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
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
}
