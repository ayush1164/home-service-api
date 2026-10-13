package com.homeservices.booking.controller;

import com.homeservices.booking.dto.serviceoffering.request.ServiceOfferingCreateRequest;
import com.homeservices.booking.dto.serviceoffering.response.ServiceOfferingResponse;
import com.homeservices.booking.service.ServiceOfferingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/service/offerings")
public class ServiceOfferingController {

    private final ServiceOfferingService offeringService;

    public ServiceOfferingController(ServiceOfferingService offeringService){
        this.offeringService = offeringService;
    }

    @PostMapping
    public ResponseEntity<ServiceOfferingResponse> create(@RequestBody ServiceOfferingCreateRequest request){
        ServiceOfferingResponse response = offeringService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/service/offering/" + response.getId())).body(response);
    }

    @GetMapping("/{service_id}")
    public ResponseEntity<ServiceOfferingResponse> get(@PathVariable ("service_id") Long serviceId){
        return ResponseEntity.ok().body(offeringService.get(serviceId));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOfferingResponse>> getAll(){
        List<ServiceOfferingResponse> responseList = offeringService.getAll();
        return ResponseEntity.ok().body(responseList);
    }

    /*
    URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/categories")
                .build()
                .toUri();
     */

}
