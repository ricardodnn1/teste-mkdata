package br.ricardo.crud.domain.dto;
 
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
 
import br.ricardo.crud.domain.entity.Customer;
 
@Transactional
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomerDto {
    
    private Long id;
    private String name;
    private String cpfCnpj;
    private String rgIe;
    private String status;
    private String typePerson;  
    private List<ContactDto> contactsDto = new ArrayList<>();

    public static CustomerDto from(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setCpfCnpj(customer.getCpfCnpj());
        customerDto.setRgIe(customer.getCpfCnpj());
        customerDto.setStatus(customer.getStatus());
        customerDto.setTypePerson(customer.getTypePerson());
        customerDto.setContactsDto(customer.getContacts().stream().map(ContactDto::from).collect(Collectors.toList()));
        return customerDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public List<ContactDto> getContactsDto() {
        return contactsDto;
    }

    public void setContactsDto(List<ContactDto> contactsDto) {
        this.contactsDto = contactsDto;
    }
  
}
