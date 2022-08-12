package br.com.ricardodn.teste_mkdata.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ricardodn.teste_mkdata.domain.entities.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
    
    

}
