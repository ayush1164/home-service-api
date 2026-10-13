package com.homeservices.booking.dto.providerprofile.request;

public class ProviderProfilePatchRequest {

    private String bio;
    private String experiencedYears;
    private Double rating;
    private Boolean is_available;

    public ProviderProfilePatchRequest() {

    }

    public ProviderProfilePatchRequest(String bio, String experiencedYears, Double rating, Boolean is_available) {

        this.bio = bio;
        this.experiencedYears = experiencedYears;
        this.rating = rating;
        this.is_available = is_available;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getIs_available() {
        return is_available;
    }

    public void setIs_available(Boolean is_available) {
        this.is_available = is_available;
    }

}
