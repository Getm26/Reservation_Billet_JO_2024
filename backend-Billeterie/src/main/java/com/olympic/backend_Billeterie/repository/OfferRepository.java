

package com.olympic.backend_Billeterie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olympic.backend_Billeterie.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
