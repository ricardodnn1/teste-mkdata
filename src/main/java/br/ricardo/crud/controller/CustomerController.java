package br.ricardo.crud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ricardo.crud.domain.dto.CustomerDto;
import br.ricardo.crud.domain.entity.Customer;
import br.ricardo.crud.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
        
    private final CustomerServiceImpl customerService;   
        
    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDto> customerDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/save")
    public void save(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @PutMapping
    @RequestMapping("/update")
    public void update(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
