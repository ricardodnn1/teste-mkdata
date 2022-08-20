package br.ricardo.crud.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import br.ricardo.crud.domain.entity.Customer;
import br.ricardo.crud.domain.repository.CustomerRepository;
import br.ricardo.crud.domain.service.CustomerService;

@Service 
public class CustomerServiceImpl implements CustomerService {
  
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() { 
        return StreamSupport
        .stream(customerRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    } 

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) { 
        if(customer.getId() > 0)
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
 
} 