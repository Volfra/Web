package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	@Query("{ 'lastname' : /.*?0.*/ }")
	List<Customer> findCustomersQ1(String name);
	
	@Query("{ 'listaCompras.total' : { $gt: 60000, $lt: 200000 } }") 
	List<Customer> findCustomersQ2();
	
	@Query("{ mediosPago : {debito : 'davivienda', credito : 'bancolombia'}}")
	List<Customer> findCustomersQ3();
	
	@Query("{ 'mediosPago.debito' : 'davivienda' }")
	List<Customer> findCustomersQ4();

	@Query(value="{ 'mediosPago.debito' : 'davivienda' }", fields="{'listaCompras' : 1, '_id' : 0}")
	List<Customer> findCustomersQ5();
	
}
