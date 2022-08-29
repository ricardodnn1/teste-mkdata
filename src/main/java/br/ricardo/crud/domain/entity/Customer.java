package br.ricardo.crud.domain.entity;
 
import java.util.ArrayList;
import java.util.List;  
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.ricardo.crud.domain.dto.CustomerDto;

@Entity
@Table(name="customers")
public class Customer  extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    private Long id;

    @NotBlank(message = "Nome não informado")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Selecione o tipo de pessoa")
    @Column(nullable = false) 
    private String typePerson;

    @NotBlank(message = "CPF/CNPJ não informado")
    @Column(nullable = false)
    private String cpfCnpj;

    @Column(nullable = false)
    private String rgIe;

    @Column(nullable = false)
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_id", referencedColumnName = "id")
    private List<Contact> contacts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public static Customer from(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setCpfCnpj(customerDto.getCpfCnpj());
        customer.setRgIe(customerDto.getRgIe());
        customer.setStatus(customerDto.getStatus());
        customer.setTypePerson(customerDto.getTypePerson());
        return customer;
    }

}
