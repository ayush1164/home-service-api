package com.homeservices.booking.repository;

import com.homeservices.booking.entity.ProviderOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderOfferingRepository extends JpaRepository<ProviderOffering, Long> {

//    @Query(
//            """
//                SELECT ps
//                FROM ProviderService ps
//                            WHERE ps.providerProfile.id = :providerId
//            """
//    )

//    Spring Data JPA derived query methods.
//    List<ProviderOffering> findByProviderId(@Param("providerId") long providerId);

//    List<ProviderOffering> findByProviderProfileId(Long providerId);

    boolean existsByProviderProfileIdAndServiceId(
            Long providerId,
            Long serviceId
    );

    /*
        The method name:
        existsByProviderProfileIdAndServiceId
        tells Spring Data JPA to check whether a record exists where:
        - providerProfile.id matches providerId
        - service.id matches serviceId

        For example, imagine your database contains:
        Provider ID	Service ID
        5	2
        5	4
        7	2

        Then:
        existsByProviderProfileIdAndServiceId(5L, 2L);
        returns true.

        But:
        existsByProviderProfileIdAndServiceId(7L, 4L);
        returns false.

        You don't need to write SQL or JPQL. Spring Data JPA derives the query from the method name.
     */

}
