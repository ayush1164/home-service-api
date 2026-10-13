package com.homeservices.booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "provider_services",
    uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_provider_service",
                columnNames = {"provider_id, service_id"}
        )
    }
)
public class ProviderOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ProviderProfile providerProfile;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceOffering service;

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

    public ProviderOffering() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
