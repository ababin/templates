package ru.babin.web.dbmodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@ToString
@EqualsAndHashCode(of={"id"})
@javax.persistence.Entity
@javax.persistence.Table(name = "CUSTOMER_ACCOUNT")
public @Data class CustomerAccount {
    
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name = "ID", nullable = false)
    private Long id;
    
    @javax.persistence.Column(name = "NAME")
    private String name;
        
}   
