package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService  implements ICustomerService{
  private CustomerRepository repository;

  @Autowired
    CustomerService(CustomerRepository repo){
       this.repository = repo;
  }
    @Override
  public Customer create(Customer customer){
      return repository.save(customer);
  }
    @Override
  public Customer read(Long customerId){
      return repository.findById(customerId).orElse(null);
  }
    @Override
  public Customer update(Customer customer){
      return repository.save(customer);
  }
    @Override
  public List<Customer> getall(){
      return repository.findAll();
  }
 /* public Customer findCustomer(Long id){
      return repository.findByCustomerId(id);
  }*/


}
