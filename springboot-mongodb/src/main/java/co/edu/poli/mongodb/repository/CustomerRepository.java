package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	@Query("{ 'name' : /.*?0.*/ }")
	List<Customer> findCustomersQ1(String name);
	
	@Query("{ 'transactions.total' : { $gt: 600, $lt: 2000 } }") 
	List<Customer> findCustomersQ2();
	
	@Query("{ cards : {debit : 'visa', credit : 'visa'}}")
	List<Customer> findCustomersQ3();
	
	@Query("{ 'cards.debit' : 'master' }")
	List<Customer> findCustomersQ4();

	@Query(value="{ 'cards.debit' : 'visa' }", fields="{'transactions' : 1, 'cards' : 1, '_id' : 0}")
	List<Customer> findCustomersQ5();
	
}
