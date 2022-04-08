
package co.edu.poli.act3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.poli.act3.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Spring Data Derived findBy Query Methods
	//Retrieve all records from the database based on the UserName
	//https://www.websparrow.org/spring/spring-data-derived-findby-query-methods-example
	User findByUserName(String userName);
}
