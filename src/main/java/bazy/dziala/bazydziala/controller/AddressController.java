package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.Address;
import bazy.dziala.bazydziala.model.User;
import bazy.dziala.bazydziala.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Address> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Address>> getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<Address> updateUser(@RequestBody Address address){
        return ResponseEntity.ok(addressService.updateAddress(address));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<Address> createUser(@RequestBody Address address){
        return ResponseEntity.ok(addressService.createAddress(address));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }
}
