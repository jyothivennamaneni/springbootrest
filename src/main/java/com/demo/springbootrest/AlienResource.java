package com.demo.springbootrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
	@Autowired
	AlienRepository repo;
	
	@RequestMapping(value="/aliens", method=RequestMethod.GET)
	public List<Alien> getAliens()
	{
		List<Alien> aliens =(List<Alien>)repo.findAll();
		
		return aliens;
		
	}
	@GetMapping(value="/alien/{id}")
	public Alien getAlien(@PathVariable("id") Integer id)
	{
		Optional<Alien> alien = repo.findById(id);
		
		
		return alien.isPresent() ? alien.get() : new Alien();
		
	}
	
	@GetMapping(value="/alien")
	public Alien getAlien(@RequestParam("name") String name)
	{
		Alien alien = repo.findByName(name);
		
		
		return alien;
		
	}
	@RequestMapping(value = "/alien", method = RequestMethod.POST)
	public Alien createAlien(@RequestBody Alien a1)
	{
		 repo.save(a1);
		
		
		return a1;
		
	}
	@RequestMapping(value = "/alien", method = RequestMethod.PUT)
	public Alien updateAlien(@RequestBody Alien a1)
	{
		 repo.save(a1);
		
		
		return a1;
		
	}
	
	@RequestMapping(value = "/alien/{id}", method = RequestMethod.DELETE)
	public Optional<Alien> deleteAlien(@PathVariable("id") Integer id)
	{
		Optional<Alien> alien=repo.findById(id) ;
		
		repo.deleteById(id);
		
		
		return alien;
		
		
	}
	

	
}
