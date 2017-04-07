package ru.babin.web.dbmodel;


@javax.persistence.Entity
@javax.persistence.Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {

    private Long id;
    
    private String name;
        
    
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @javax.persistence.Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}   
