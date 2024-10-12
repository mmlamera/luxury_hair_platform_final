package za.ac.cput.services;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;

import java.util.List;

public interface ICustomerService extends IService<Customer,Long>{
    List<Customer> getall();
}
