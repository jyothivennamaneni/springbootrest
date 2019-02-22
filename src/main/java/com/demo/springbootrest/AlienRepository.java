package com.demo.springbootrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;



import java.util.List;
import java.util.Optional;


public interface AlienRepository extends JpaRepository<Alien, Integer>
{

	Alien findByName(String name);
	//void saveAlien(Alien alien);
	
}
