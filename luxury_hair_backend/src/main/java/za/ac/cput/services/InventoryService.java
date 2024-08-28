package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService implements IInventoryService{
    private InventoryRepository repository;

    @Autowired

    InventoryService(InventoryRepository repository){this.repository=repository;
    }
    @Override
    public Inventory create(Inventory inv){return repository.save(inv);
    }

    @Override
    public Inventory read(String invID){return repository.findById(invID).orElse (null);
    }
    @Override
    public Inventory update(Inventory inv){return repository.save(inv);
    }
    @Override
    public List<Inventory> getall(){return repository.findAll();
    }
}
