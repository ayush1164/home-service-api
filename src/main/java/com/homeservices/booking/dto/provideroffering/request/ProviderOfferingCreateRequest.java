package com.homeservices.booking.dto.provideroffering.request;

public class ProviderOfferingCreateRequest {

    private Long providerId;
    private Long serviceId;

    // Keep the no-arg constructor for serialization frameworks (like Jackson)
    public ProviderOfferingCreateRequest(){
    }

    // FIXED: Changed primitive long to wrapper Long
    public ProviderOfferingCreateRequest(Long providerId, Long serviceId){
        this.providerId = providerId;
        this.serviceId = serviceId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}