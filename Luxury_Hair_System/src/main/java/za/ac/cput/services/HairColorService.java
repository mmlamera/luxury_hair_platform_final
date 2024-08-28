package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.HairColor;
import za.ac.cput.repository.HairColorRepository;

import java.util.List;
import java.util.Set;

@Service
public class HairColorService implements IHairColorService{
private HairColorRepository repo;
@Autowired
    HairColorService(HairColorRepository repository){this.repo = repository;}

    @Override
    public List<HairColor> getall() {
        return repo.findAll();
    }

    @Override
    public HairColor create(HairColor hairColor) {
        return repo.save(hairColor);
    }

    @Override
    public HairColor read(String s) {
        return repo.findById(s).orElse(null);
    }

    @Override
    public HairColor update(HairColor hairColor) {
        return repo.save(hairColor);
    }
}
