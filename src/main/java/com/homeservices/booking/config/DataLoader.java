package com.homeservices.booking.config;

import com.homeservices.booking.entity.*;
import com.homeservices.booking.enums.Role;
import com.homeservices.booking.enums.Status;
import com.homeservices.booking.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//@Configuration
public class DataLoader {
/*
    @Bean
    CommandLineRunner loadData
            (
                    CategoryRepository categoryRepository,
                    ServiceOfferingRepository serviceRepository,
                    UserRepository userRepository,
                    ProviderProfileRepository providerProfileRepository,
                    ProviderOfferingRepository providerServiceRepository,
                    BookingRepository bookingRepository,
                    HibernateTestService testService
            ){
        return args -> {
            System.out.println("Application Started Running...");
            System.out.println("Load Sample Data....");

            Category plumbing = new Category("Plumbing", "Plumbing is needed for Household.");
            Category cleaning = new Category("Cleaning", "Cleaning is also need for joyfull house");
            Category electrical = new Category("Electrical", "Electrical appliances is live of home.");

            categoryRepository.save(plumbing);
            categoryRepository.save(cleaning);
            categoryRepository.save(electrical);

//            categoryRepository.deleteAll();

            ServiceOffering homeCleaning = new ServiceOffering(
                    "Home Cleaning",
                    "Complete home cleaning service"
            );

            ServiceOffering bathroomCleaning = new ServiceOffering(
                    "Bathroom Cleaning",
                    "Deep bathroom cleaning service"
            );

            ServiceOffering pipeRepair = new ServiceOffering(
                    "Pipe Repair",
                    "Repair leaking and damaged pipes"
            );

            ServiceOffering fanInstallation = new ServiceOffering(
                    "Fan Installation",
                    "Ceiling and wall fan installation"
            );

            homeCleaning.setCategory(cleaning);
            bathroomCleaning.setCategory(cleaning);
            pipeRepair.setCategory(plumbing);
            fanInstallation.setCategory(electrical);

            serviceRepository.save(homeCleaning);
            serviceRepository.save(bathroomCleaning);
            serviceRepository.save(pipeRepair);
            serviceRepository.save(fanInstallation);

//            List<Category> categoryList = categoryRepository.findAll();
//            categoryList
//                    .forEach(System.out::println);

            User rahul = new User("Rahul Narvekar", "rahul@gmail.com", "rahul@pass", "9874523215", "Nagpur", Role.CLIENT);
            User lokesh = new User("Lokesh Pethe", "lokesh@gmail.com", "lokesh@pass", "9865231452", "Wardha", Role.PROVIDER);
            User nilesh = new User("Nilesh Patil", "nilesh@gmail.com", "nilesh@pass", "7845126352", "Nagpur", Role.PROVIDER);

            userRepository.save(rahul);
            userRepository.save(lokesh);
            userRepository.save(nilesh);

            ProviderProfile profile1 = new ProviderProfile("I'm proficient in my work and client satisfaction", "5+" , 4.5, true);
            ProviderProfile profile2 = new ProviderProfile("I do work very sofisticatelly", "7+" , 4.3, true);

            profile1.setUser(lokesh);
            profile2.setUser(nilesh);

            providerProfileRepository.save(profile1);
            providerProfileRepository.save(profile2);

            ProviderOffering psl = new ProviderOffering();

            psl.setService(fanInstallation);
            psl.setProviderProfile(profile2);

            profile2.getProviderServiceList().add(psl);

            providerServiceRepository.save(psl);

//            saving as response object
            Booking rahulsBooking = new Booking();
            rahulsBooking.setBookingDate(LocalDateTime.now());
            rahulsBooking.setScheduledDate(LocalDate.of(2026, 9, 11));
            rahulsBooking.setScheduledTime(LocalTime.of(15, 30, 0));
            rahulsBooking.setClientNotes("plz Come on well equipped and on time.");
            rahulsBooking.setStatus(Status.ACCEPTED);
            rahulsBooking.setUser(rahul);
            rahulsBooking.setProviderProfile(profile1);
            rahulsBooking.setService(homeCleaning);
            rahulsBooking.setTotalAmount(900.00);

            bookingRepository.save(rahulsBooking);

            testService.testCategory();

            testService.testProviderService();

            testService.testJPQL();

        };

    }
*/
}
