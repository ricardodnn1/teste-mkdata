package br.com.ricardodn.teste_mkdata.domain.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table; 
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
 
@Entity
@Table(name = "customers") 
@EntityListeners(AuditingEntityListener.class)
public class CustomersEntity extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String typePerson;
    @Column(nullable = false)
    private String cpfCnpj;
    @Column(nullable = false)
    private String rgIE;
    @Column(nullable = false)
    private String status; 
    @Column(nullable = false)
    private String phone;  
    
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
    
    public String getRgIE() {
        return rgIE;
    }
    
    public void setRgIE(String rgIE) {
        this.rgIE = rgIE;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
} 
  