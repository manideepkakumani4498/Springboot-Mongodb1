package com.spring.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.Service.CellService;
import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;

@RestController
public class CellController {
	@Autowired
	private CellService cellservice;
	@PostMapping("add")
	public String method(@RequestBody CellList cellList) {
		cellservice.save(cellList);
		return "celllist added:"+cellList.getId();
	}
	@GetMapping("fetch")
	public List<CellList> method1(){
		return cellservice.getall();
	}
	@GetMapping("fetch/{id}")
	public Optional<CellList> method2(@PathVariable int id) {
		return cellservice.getbyid(id);
	}
	@PutMapping("update")
	public String method3(@RequestBody CellList cellList) {
		cellservice.update(cellList);
		return "celllist updated:"+cellList.getId();
	}
	@DeleteMapping("deleteall")
	public void deleteall() {
		cellservice.deleteall();
	}
	@DeleteMapping("delete/{id}")
	public void deletebyid(@PathVariable int id) {
		cellservice.deletebyid(id);
	}
}
