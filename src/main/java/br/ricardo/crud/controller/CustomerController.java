package br.ricardo.crud.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDto> customerDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
   
    @CrossOrigin(origins = "*")
    @GetMapping("/list/{id}")
    public ResponseEntity<List<CustomerDto>> getCustomerById(@PathVariable Long id) {
        List<Customer> customers = customerService.getCustomer(id);
        List<CustomerDto> customerDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
        if(customerService.findByCpfCnpj(customer.getCpfCnpj().toString()) == null) { 
            return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.OK);
        } else { 
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    @RequestMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody @Valid Customer customer) { 
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<CustomerDto> delete(@PathVariable Long id) {
        Customer customer = customerService.deleteCustomer(id);
        return new ResponseEntity<CustomerDto>(CustomerDto.from(customer), HttpStatus.OK); 
    }

}
