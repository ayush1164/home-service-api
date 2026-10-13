package com.homeservices.booking.dto.booking.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingCreateRequest {

    private Long userId;
    private Long serviceId;
    private Long providerId;

    // Matches the "YYYY-MM-DD" string format coming from the client
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate scheduledDate;
    // Matches 24-hour formats like "14:30:00" or "09:15:00"
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime scheduledTime;

    private String clientNotes;

    public BookingCreateRequest(){

    }

    public BookingCreateRequest(Long userId, Long serviceId, Long providerId, LocalDate scheduledDate,LocalTime scheduledTime, String clientNotes){
        this.userId = userId;
        this.serviceId = serviceId;
        this.providerId = providerId;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.clientNotes = clientNotes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
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

    public String getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(String clientNotes) {
        this.clientNotes = clientNotes;
    }
}
