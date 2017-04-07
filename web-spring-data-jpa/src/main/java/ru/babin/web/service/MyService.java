package ru.babin.web.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.babin.web.dbmodel.CustomerAccount;
import ru.babin.web.repo.CustomerAccountRepo;

@Service
public class MyService {
	
    @Autowired
    CustomerAccountRepo caRepo;
    
	public int getNumber(){
		return 45;
	}
	
	@Transactional
	public List <String> getCustomerAccounts(){
		
	    Iterable <CustomerAccount> accounts  = caRepo.findAll();
		return prepareList(accounts);
	}
	
	private List <String> prepareList(Iterable <CustomerAccount> accounts){
	    List <String> list  = new LinkedList<>();
	    Iterator <CustomerAccount> it = accounts.iterator();
	    while(it.hasNext()){
	        CustomerAccount ca = it.next();
	        list.add(ca.getName());
	    }
	    return list;
	}
	
}
