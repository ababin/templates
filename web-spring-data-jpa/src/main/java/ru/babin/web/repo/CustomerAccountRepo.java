package ru.babin.web.repo;

import org.springframework.data.repository.CrudRepository;

import ru.babin.web.dbmodel.CustomerAccount;

public interface CustomerAccountRepo  extends CrudRepository<CustomerAccount, Long>{

}
