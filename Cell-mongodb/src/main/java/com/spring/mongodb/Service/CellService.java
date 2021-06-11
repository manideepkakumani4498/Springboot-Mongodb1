package com.spring.mongodb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;

@Service
public class CellService {
	@Autowired
	private CellRepositories cellRepositories;
	
	public int save(CellList cellList) {
		cellRepositories.insert(cellList);
		return cellList.getId();
	}
	
	public List<CellList> getall(){
		return cellRepositories.findAll();
	}
	public Optional<CellList> getbyid(int id) {
		return cellRepositories.findById(id);
	}
	public String update(CellList cellList) {
		cellRepositories.save(cellList);
		return "record updated successfully:"+cellList.getId();
	}
	public void deletebyid(int id) {
		cellRepositories.deleteById(id);
	}
	public void deleteall() {
		cellRepositories.deleteAll();
	}
	

}
