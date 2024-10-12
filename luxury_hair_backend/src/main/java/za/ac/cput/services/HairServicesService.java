package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HairServices;
import za.ac.cput.repository.HairServicesRepository;

import java.util.List;

@Service
public class HairServicesService implements IHairServices {
    @Autowired
    private HairServicesRepository repository;

    @Override
    public List<HairServices> getall() {
        return repository.findAll();
    }

    @Override
    public HairServices create(HairServices hairServices) {
        return repository.save(hairServices);
    }

    @Override
    public HairServices read(Integer integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public HairServices update(HairServices hairServices) {
        return repository.save(hairServices);
    }
}