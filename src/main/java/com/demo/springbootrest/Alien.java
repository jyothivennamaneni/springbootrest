package com.demo.springbootrest;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Alien {

	private String name;
	private int points;
	@Id
	private Integer id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	public Alien(String name, int points, Integer id) {
		super();
		this.name = name;
		this.points = points;
		this.id = id;
	}
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
