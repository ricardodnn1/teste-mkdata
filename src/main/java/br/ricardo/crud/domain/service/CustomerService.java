package br.ricardo.crud.domain.service;

import java.util.List;

import br.ricardo.crud.domain.entity.Customer;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomer(Long id);

    Customer deleteCustomer(Long id);

    Customer findByCpfCnpj(String cnpfCnpj);
}
