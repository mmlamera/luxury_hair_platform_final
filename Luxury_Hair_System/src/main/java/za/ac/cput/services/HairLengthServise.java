package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.HairLength;
import za.ac.cput.repository.HairLengthRepository;


import java.util.List;
@Service
public class HairLengthServise implements IHairLengthService{
private static HairLengthRepository repo;
@Autowired
HairLengthServise(HairLengthRepository repository){this.repo=repository;}
    @Override
    public List<HairLength> getall() {
        return repo.findAll();
    }

    @Override
    public HairLength create(HairLength hairLength) {
        return repo.save(hairLength);
    }

    @Override
    public HairLength read(Integer integer) {
        return repo.findById(String.valueOf(integer)).orElse(null);
    }

    @Override
    public HairLength update(HairLength hairLength) {
        return repo.save(hairLength);
    }
}
