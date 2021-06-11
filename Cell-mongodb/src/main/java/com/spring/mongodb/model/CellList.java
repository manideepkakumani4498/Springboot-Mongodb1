package com.spring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CellList")
public class CellList {
	@Id
	private int id;
	private String name;
	private int ram;
	
	public CellList(int id, String name, int ram) {
		super();
		this.id = id;
		this.name = name;
		this.ram = ram;
	}

	public CellList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
	
}
