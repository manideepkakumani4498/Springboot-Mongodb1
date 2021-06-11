package com.spring.mongodb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongodb.assertions.Assertions;
import com.spring.mongodb.Service.CellService;
import com.spring.mongodb.model.CellList;
import com.spring.mongodb.repositories.CellRepositories;


@SpringBootTest
class CellMongodbApplicationTests {
	@Autowired
	private CellService cellService;
	@Mock
	private CellRepositories repo;
	
	@Test
	public void savetest() throws Exception {
		CellList cell=new CellList(1003,"oneplus",12);
		when(repo.save(cell)).thenReturn(cell);
		assertEquals(1003,cell.getId());
	}
	@Test
	public void getall1test() {
		List<CellList> mainlist=new ArrayList<>();
		CellList cell=new CellList(700,"iphone",6);
		CellList cell1=new CellList(701,"oneplus",12);
		mainlist.add(cell);
		mainlist.add(cell1);
		when(repo.findAll()).thenReturn(mainlist);
		assertEquals(2,mainlist.size());
	}

	@Test
	public void updatetest() {
		CellList cellList=new CellList(111,"oneplus",12);
		when(repo.save(cellList)).thenReturn(cellList);
		assertEquals(111,cellList.getId());
	}
	@Test
	public void deletetest() {
		CellList cell=new CellList(123,"oneplus",12);
		repo.deleteById(cell.getId());
		verify(repo,times(1)).deleteById(cell.getId());
	}
	
}
