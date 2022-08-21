package br.ricardo.crud.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import br.ricardo.crud.domain.entity.Customer;
import br.ricardo.crud.domain.repository.CustomerRepository;
import br.ricardo.crud.domain.service.CustomerService;
import br.ricardo.crud.exception.CustomerNotFoundException;

@Service 
public class CustomerServiceImpl implements CustomerService {
  
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() { 
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).collect(Collectors.toList());
    } 

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerObj = customer;
        customerRepository.save(customerObj);
        return customerObj;
    }

    @Override
    public Customer updateCustomer(Customer customer) { 
        Customer customerObj = customer;
        if(customer.getId() > 0)
            customerRepository.save(customerObj);

        return customerObj;
    }

    @Override
    public Customer deleteCustomer(Long id) { 
        Customer customerObj = getCustomer(id);
        customerRepository.delete(customerObj); 
        return customerObj;
    }
 
} 