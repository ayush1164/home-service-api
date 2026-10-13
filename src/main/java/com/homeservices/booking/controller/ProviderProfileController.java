package com.homeservices.booking.controller;

import com.homeservices.booking.dto.providerprofile.request.ProviderProfileCreateRequest;
import com.homeservices.booking.dto.providerprofile.response.ProviderProfileResponse;
import com.homeservices.booking.service.ProviderProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/provider/profile")
public class ProviderProfileController {

    private final ProviderProfileService providerProfileService;

    public ProviderProfileController(ProviderProfileService providerProfileService){
        this.providerProfileService = providerProfileService;
    }

    @PostMapping
    private ResponseEntity<ProviderProfileResponse> create(@RequestBody ProviderProfileCreateRequest request){
        ProviderProfileResponse response = providerProfileService.create(request);
        URI location = URI.create("/api/v1/provider/profile" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    private ResponseEntity<List<ProviderProfileResponse>> getAll(){
        List<ProviderProfileResponse> responseList = providerProfileService.getAll();
        return ResponseEntity.ok().body(responseList);
    }

    @GetMapping("/{profile_id}")
    private ResponseEntity<ProviderProfileResponse> getById(@PathVariable ("profile_id") Long profileId){
        return ResponseEntity.ok().body(providerProfileService.getById(profileId));
    }

}
