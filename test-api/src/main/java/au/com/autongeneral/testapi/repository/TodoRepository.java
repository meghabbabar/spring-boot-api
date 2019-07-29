package au.com.autongeneral.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.autongeneral.testapi.entities.ToDoItem;

@Repository
public interface TodoRepository extends JpaRepository<ToDoItem, Long>{
	
}
