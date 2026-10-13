package com.homeservices.booking.controller;

import com.homeservices.booking.dto.booking.request.BookingCreateRequest;
import com.homeservices.booking.dto.booking.response.BookingResponse;
import com.homeservices.booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody BookingCreateRequest request){
        BookingResponse response = bookingService.create(request);
        URI location = URI.create("/api/v1/bookings/" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{booking_id}")
    public ResponseEntity<BookingResponse> getById(@PathVariable ("booking_id") Long bookingId){
        return ResponseEntity.ok().body(bookingService.getById(bookingId));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAll(){
        List<BookingResponse> responseList = bookingService.getAll();
        return ResponseEntity.ok().body(responseList);
    }

}
