package br.ricardo.crud.domain.repository;
   

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
 
import br.ricardo.crud.domain.entity.Customer;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Long> { 
 
    @Query(value = "SELECT * FROM customers WHERE cpf_cnpj = ?1", nativeQuery = true)
    Customer findByCpfCnpj(String cnpfCnpj);
     
    List<Customer> findCustomerById(Long id);
} 