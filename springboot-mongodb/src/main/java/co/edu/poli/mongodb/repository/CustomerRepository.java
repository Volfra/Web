package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	@Query("{name : /.*?0.*/ }")
	List<Customer> findCustomers(String name);
	
	@Query("{balance : { $gt: ?0, $lt: ?1 }}") 
	List<Customer> findCustomersQ1(double min, double max);
		
	@Query("{skills:  {job: 'engineer', education: 'phd', languages: 'korean'}}")
	List<Customer> findCustomersQ2();
	
	@Query("{'skills.job' : 'engineer' }")
	List<Customer> findCustomersQ3();

	@Query(value="{ 'skills.job' : 'engineer' }", fields="{'transactions' : 1, 'skills' : 1, '_id' : 0}")
	List<Customer> findCustomersQ4();
	
	@Query(value="{ $or : [ { name : /.*K.*/}, {balance : { $gte : 3000}  } ]  }", fields="{'name' : 1, 'balance' : 1, '_id' : 0}")
	List<Customer> findCustomersQ5();

}
