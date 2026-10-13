package com.homeservices.booking.controller;

import com.homeservices.booking.dto.provideroffering.request.ProviderOfferingCreateRequest;
import com.homeservices.booking.dto.provideroffering.response.ProviderOfferingResponse;
import com.homeservices.booking.service.ProviderOfferingService;
import com.homeservices.booking.service.impl.ProviderOfferingServiceImplement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/provider/offerings")
public class ProviderOfferingController {

    private final ProviderOfferingService providerOfferingService;

    public ProviderOfferingController(ProviderOfferingService providerOfferingService){
        this.providerOfferingService = providerOfferingService;
    }

    @PostMapping
    public ResponseEntity<ProviderOfferingResponse> create(@RequestBody ProviderOfferingCreateRequest request){
        ProviderOfferingResponse response = providerOfferingService.create(request);
        URI location = URI.create("/api/v1/provider/offering" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{offering_id}")
    public ResponseEntity<ProviderOfferingResponse> getById(@PathVariable ("offering_id") Long offeringId){
        return ResponseEntity.ok().body(providerOfferingService.getById(offeringId));
    }

    @GetMapping
    public ResponseEntity<List<ProviderOfferingResponse>> getAll(){
        List<ProviderOfferingResponse> responseList = providerOfferingService.getAll();
        return ResponseEntity.ok().body(responseList);
    }

}
