package org.example.service;

import org.example.model.Buyer;

import java.util.List;

public interface BuyerService {
    Buyer getById(Long id);

    void save(Buyer buyer);

    void delete(Long id);

    List<Buyer> getAll();
}
