package com.olympic.backend_Billeterie.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olympic.backend_Billeterie.model.Offer;
import com.olympic.backend_Billeterie.repository.OfferRepository;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerRepository.save(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer offerDetails) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + id));
        offer.setName(offerDetails.getName());
        offer.setDescription(offerDetails.getDescription());
        offer.setMaxPersons(offerDetails.getMaxPersons());
        return offerRepository.save(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + id));
        offerRepository.delete(offer);
    }
}
