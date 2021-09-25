package org.learn.domain;

public class City {
	//城市id
	private Long id;
	//城市名
	private String name;
	//父级城市
	private City parent;
	
	
	
	public City() {
		super();
	}
	public City(Long id, String name, City parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getParent() {
		return parent;
	}
	public void setParent(City parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
