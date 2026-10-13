package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.booking.request.BookingCreateRequest;
import com.homeservices.booking.dto.booking.response.BookingResponse;
import com.homeservices.booking.entity.Booking;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.ServiceOffering;
import com.homeservices.booking.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BookingMapper {

    public Booking toEntity(
            BookingCreateRequest request,
            User user,
            ProviderProfile profile,
            ServiceOffering serviceOffering
    ) {
        if (request == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setProviderProfile(profile);
        booking.setService(serviceOffering);
        booking.setScheduledTime(request.getScheduledTime());
        booking.setScheduledDate(request.getScheduledDate());
        booking.setBookingDate(LocalDateTime.now());
        booking.setClientNotes(request.getClientNotes());

        return booking;

    }

    public BookingResponse toResponse(Booking booking){
        if (booking == null) {
            return null;
        }

        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        if (booking.getUser() != null){
            response.setUserId(booking.getUser().getId());
            response.setUserName(booking.getUser().getName());
        }
        if (booking.getService() != null) {
            response.setServiceId(booking.getService().getId());
            response.setServiceName(booking.getService().getName());
        }
        if (booking.getProviderProfile() != null){
            response.setProviderId(booking.getProviderProfile().getId());
            response.setProviderName(booking.getProviderProfile().getName());
        }
        response.setBookingDate(booking.getBookingDate());
        response.setScheduledTime(booking.getScheduledTime());
        response.setScheduledDate(booking.getScheduledDate());
        response.setStatus(booking.getStatus());
        response.setTotalAmount(booking.getTotalAmount());
        response.setClientNotes(booking.getClientNotes());

        return response;
    }

}
