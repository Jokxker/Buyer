package org.example.rest;

import org.example.model.Buyer;
import org.example.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyers/")
public class BuyerRestControllerV1 {
    @Autowired
    private BuyerService buyerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Buyer> getBuyer(@PathVariable("id") Long buyerId) {
        if(buyerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Buyer buyer = this.buyerService.getById(buyerId);

        if(buyer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Buyer> saveBuyer(@RequestBody @Validated Buyer buyer) {
        HttpHeaders headers = new HttpHeaders();

        if (buyer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.buyerService.save(buyer);
        return new ResponseEntity<>(buyer, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Buyer> updateBuyer(@RequestBody @Validated Buyer buyer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (buyer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.buyerService.save(buyer);

        return new ResponseEntity<>(buyer, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Buyer> deleteBuyer(@PathVariable("id") Long id) {
        Buyer buyer = this.buyerService.getById(id);

        if (buyer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.buyerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Buyer> getAllBuyers() {
        List<Buyer> buyers = this.buyerService.getAll();

        if (buyers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
