package br.ricardo.crud.domain.service;

import java.util.List;

import br.ricardo.crud.domain.entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

}
