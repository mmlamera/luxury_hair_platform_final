package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    private AddressRepository repo;
    @Autowired
    AddressService(AddressRepository repository){
         this.repo = repository;
    }

    @Override
    public List<Address> getall() {
        return repo.findAll();
    }

    @Override
    public Address create(Address address) {
        return repo.save(address);
    }

    @Override
    public Address read(Long aLong) {
        return repo.findById(aLong).orElse(null);
    }

    @Override
    public Address update(Address address) {
        return repo.save(address);
    }
}
