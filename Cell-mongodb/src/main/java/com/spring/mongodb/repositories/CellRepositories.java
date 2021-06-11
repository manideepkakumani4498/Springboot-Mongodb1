package com.spring.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.model.CellList;

public interface CellRepositories extends MongoRepository<CellList, Integer> {

}
