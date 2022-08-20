package br.ricardo.crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.ricardo.crud.domain.entity.Contact;

@Repository
@EnableJpaRepositories
public interface ContactRepository extends JpaRepository<Contact, Long> {     
}