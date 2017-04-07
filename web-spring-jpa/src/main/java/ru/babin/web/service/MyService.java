package ru.babin.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.babin.web.dbmodel.CustomerAccount;

@Service
public class MyService {
		   
    @PersistenceContext(unitName = "pu")
    EntityManager emanager;
    
    
	public int getNumber(){
		return 45;
	}
	
	@Transactional
	public List <String> getCustomerAccounts(){
		List <CustomerAccount> accounts  = emanager.createQuery("SELECT ca FROM CustomerAccount ca", CustomerAccount.class).getResultList();
		return prepareList(accounts);
	}
	
	private List <String> prepareList(List <CustomerAccount> accounts){
	    List <String> list  = new ArrayList<>(accounts.size());
	    accounts.stream().forEach(c -> list.add(c.getName()));
	    return list;
	}
	
}
