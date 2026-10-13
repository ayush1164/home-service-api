package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.booking.request.BookingCreateRequest;
import com.homeservices.booking.dto.booking.response.BookingResponse;
import com.homeservices.booking.entity.Booking;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.ServiceOffering;
import com.homeservices.booking.entity.User;
import com.homeservices.booking.enums.Status;
import com.homeservices.booking.exception.BusinessRuleException;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.BookingMapper;
import com.homeservices.booking.repository.*;
import com.homeservices.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImplement implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ProviderProfileRepository profileRepository;
    private final ServiceOfferingRepository serviceOfferingRepository;
    private final ProviderOfferingRepository providerOfferingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImplement(BookingRepository bookingRepository,
                                   UserRepository userRepository,
                                   ProviderProfileRepository profileRepository,
                                   ServiceOfferingRepository serviceOfferingRepository,
                                   BookingMapper bookingMapper,
                                   ProviderOfferingRepository providerOfferingRepository
                                   ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.serviceOfferingRepository = serviceOfferingRepository;
        this.bookingMapper = bookingMapper;
        this.providerOfferingRepository = providerOfferingRepository;
    }


    @Override
    public BookingResponse create(BookingCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ProviderProfile profile = profileRepository.findById(request.getProviderId())
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found."));

        ServiceOffering serviceOffering = serviceOfferingRepository.findById(request.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        boolean offeringExist =
                providerOfferingRepository
                        .existsByProviderProfileIdAndServiceId(
                                profile.getId(),
                                serviceOffering.getId()
                        );

        if(!offeringExist){
            throw new BusinessRuleException(
                    "This provider does not offer the selected service, " +
                            "Please look for another provider who offers this service"
            );
        }

        /*
        One improvement for later: we'll replace RuntimeException with a custom business exception and return an appropriate HTTP status, such as 400 Bad Request, rather than allowing an unexpected 500 Internal Server Error.
         */

        Booking booking = bookingMapper.toEntity(request, user, profile, serviceOffering);

        booking.setBookingDate(LocalDateTime.now());
        booking.setTotalAmount(serviceOffering.getPrice());
        booking.setStatus(Status.PENDING);

        Booking savedBooking = bookingRepository.save(booking);

        return bookingMapper.toResponse(savedBooking);
    }

    @Override
    public BookingResponse getById(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        return bookingMapper.toResponse(booking);
    }

    @Override
    public List<BookingResponse> getAll(){
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toResponse)
                .toList();
    }
}
