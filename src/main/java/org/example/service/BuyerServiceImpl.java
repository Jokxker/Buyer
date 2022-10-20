package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Buyer;
import org.example.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public Buyer getById(Long id) {
        log.info("In BuyerServiceImpl getById {}", id);
        return buyerRepository.getOne(id);
    }

    @Override
    public void save(Buyer buyer) {
        log.info("In BuyerServiceImpl save {}", buyer);
        buyerRepository.save(buyer);
    }

    @Override
    public void delete(Long id) {
        log.info("In BuyerServiceImpl delete {}", id);
        buyerRepository.deleteById(id);
    }

    @Override
    public List<Buyer> getAll() {
        log.info("In BuyerServiceImpl getAll");
        return buyerRepository.findAll();
    }
}
