package com.homeservices.booking.service;

import com.homeservices.booking.dto.booking.request.BookingCreateRequest;
import com.homeservices.booking.dto.booking.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse create(BookingCreateRequest request);

    BookingResponse getById(Long bookingId);

    List<BookingResponse> getAll();
}
