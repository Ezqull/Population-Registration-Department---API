package bazy.projekt.app.service;

import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.Address;
import bazy.projekt.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    private static final String ADDRESS_NOT_FOUND = "Address not found!";

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(@Qualifier("addressRepository") AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public Address getById(Long id){
        try {
            return addressRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(ADDRESS_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public String deleteAddress(Long id){
        Address addressToDelete = getById(id);
        addressRepository.delete(addressToDelete);
        return "Address with id: " + id + " deleted!";
    }
}
