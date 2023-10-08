package com.example.demo.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    // Create a new address
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    // Retrieve an address by ID
    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    // Retrieve all addresses
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Update an address
    public Address updateAddress(Long addressId, Address updatedAddress) {
        // Check if the address with the given ID exists
        Optional<Address> existingAddress = addressRepository.findById(addressId);
        if (existingAddress.isPresent()) {
            Address addressToUpdate = existingAddress.get();

            // Update the fields of the existing address with the new values
            addressToUpdate.setLandmark(updatedAddress.getLandmark());
            addressToUpdate.setZipcode(updatedAddress.getZipcode());
            addressToUpdate.setDistrict(updatedAddress.getDistrict());
            addressToUpdate.setState(updatedAddress.getState());
            addressToUpdate.setCountry(updatedAddress.getCountry());

            // Save the updated address to the repository
            return addressRepository.save(addressToUpdate);
        } else {
            return null; // Address not found, handle accordingly
        }
    }

    // Delete an address by ID
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
