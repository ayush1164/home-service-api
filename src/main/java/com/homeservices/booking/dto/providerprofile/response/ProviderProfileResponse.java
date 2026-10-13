package com.homeservices.booking.dto.providerprofile.response;

public class ProviderProfileResponse {

    private Long id;
    private String name;
    private Long userId;
    private String bio;
    private String experiencedYears;
    private double rating;
    private boolean is_available;

    public ProviderProfileResponse() {

    }

    public ProviderProfileResponse(Long id, String name, Long userId, String bio, String experiencedYears, double rating, boolean is_available) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.bio = bio;
        this.experiencedYears = experiencedYears;
        this.rating = rating;
        this.is_available = is_available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
