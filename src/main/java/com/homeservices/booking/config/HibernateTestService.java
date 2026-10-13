package com.homeservices.booking.config;

import com.homeservices.booking.entity.Category;
import com.homeservices.booking.entity.ProviderProfile;
import com.homeservices.booking.entity.ProviderOffering;
import com.homeservices.booking.entity.ServiceOffering;
import com.homeservices.booking.repository.CategoryRepository;
import com.homeservices.booking.repository.ProviderProfileRepository;
import com.homeservices.booking.repository.ProviderOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class HibernateTestService {

    /*
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProviderOfferingRepository providerServiceRepository;

    @Autowired
    private ProviderProfileRepository providerProfileRepository;

    @Transactional
    public void testCategory(){

        Category category = categoryRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Category not found."));
        System.out.println("Category: " + category.getName());

        for(ServiceOffering service : category.getServices()){
            System.out.println(service.getName());
            System.out.println(service.getCategory().getName());
            System.out.println(service.getBookings());
        }

    }

    @Transactional
    public void testProviderService(){

        ProviderProfile profile = providerProfileRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        System.out.println("Profile ID: " + profile.getId());

        System.out.println("ProviderService count: "
                + profile.getProviderServiceList().size());

        for (ProviderOffering ps : profile.getProviderServiceList()) {
            System.out.println("ProviderService ID: " + ps.getId());
            System.out.println("Service: " + ps.getService().getName());
        }

        /*
        List<ProviderService> list = providerServiceRepository.findAll();

        System.out.println("ProviderService count: " + list.size());

        for (ProviderService ps : list) {

            System.out.println("Provider ID: "
                    + ps.getProviderProfile().getId());

            System.out.println("Service ID: "
                    + ps.getService().getId());

            System.out.println("Service Name: "
                    + ps.getService().getName());

        }
         */
/*

    }

    @Transactional
    public void testJPQL() {

        List<ProviderOffering> providerServices =
                providerServiceRepository.findByProviderProfileId(1L);

        System.out.println("Services for provider:");

        for (ProviderOffering ps : providerServices) {
            System.out.println(
                    ps.getService().getName()
            );
        }
    }
*/
}
