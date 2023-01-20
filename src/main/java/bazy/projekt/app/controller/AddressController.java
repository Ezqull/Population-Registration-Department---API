package bazy.projekt.app.controller;

import bazy.projekt.app.model.Address;
import bazy.projekt.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id){

        return ResponseEntity.ok(addressService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Address>> getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }


    @PutMapping(path = "/update/{id}", consumes="application/json")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("id") Long id){
        address.setId(id);
        return ResponseEntity.ok(addressService.updateAddress(address));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return new ResponseEntity(addressService.createAddress(address), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id){
        return new ResponseEntity(addressService.deleteAddress(id), HttpStatusCode.valueOf(204));
    }
}
