package br.com.ricardodn.teste_mkdata.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ricardodn.teste_mkdata.data.CustomersRepository;
import br.com.ricardodn.teste_mkdata.domain.entities.CustomersEntity; 

@RestController
@RequestMapping("/customers")
public class CustomersController {
    
    @Autowired
    private CustomersRepository repositories;

    @GetMapping("/list")
    public List<CustomersEntity> listAll() {
        return repositories.findAll();
    }

    @PostMapping
    @RequestMapping("/save")
    public void saveCustomer(@RequestBody CustomersEntity customer) {
        repositories.save(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody CustomersEntity customer) {
        if(customer.getId() > 0)
          repositories.save(customer);
    }   

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        repositories.deleteById(id);
    }

}
