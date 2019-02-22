package com.demo.springbootrest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestAlienResource {
	
	@InjectMocks
	AlienResource alienResource;
	
	@Mock
	AlienRepository repo;
	
	@Test
	public void testGetAliens() {
		
		List<Alien> aliens = new ArrayList<Alien>();	
		aliens.add(new Alien("test",40, new Integer(1)));
		
		when(repo.findAll()).thenReturn(aliens);
		
		List<Alien> result = alienResource.getAliens();
		assertEquals(aliens.size(), result.size());
		assertEquals("test", result.get(0).getName());
	}
@Test
public void testGetAlien() {
	
	Alien alien=new Alien("jyo",50,new Integer(2));
	when(repo.findByName(Mockito.anyString())).thenReturn(alien);
	Alien result=alienResource.getAlien("jyo1");
	assertEquals("jyo", result.getName());
	assertEquals(50, result.getPoints());
	
	
	
}
}
