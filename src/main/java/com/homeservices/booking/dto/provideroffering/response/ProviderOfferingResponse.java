package com.homeservices.booking.dto.provideroffering.response;

public class ProviderOfferingResponse {

    private long id;
    private long providerId;
    private String providerName;
    private long serviceId;
    private String serviceName;

    public ProviderOfferingResponse() {
    }

    public ProviderOfferingResponse(long id, long providerId, String providerName, long serviceId, String serviceName) {
        this.id = id;
        this.providerId = providerId;
        this.providerName = providerName;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
