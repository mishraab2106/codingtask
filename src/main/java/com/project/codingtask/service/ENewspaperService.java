package com.project.codingtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.codingtask.entity.ENewspaperModel;
import com.project.codingtask.repos.DbRepository;

@Service
public class ENewspaperService {
	
@Autowired
private ENewspaperModel model;
@Autowired
private DbRepository repo;

public List<ENewspaperModel>sortingWithField(String field) {
//	return repo.findAll(Sort.by(field));
	return repo.findAll(Sort.by(Sort.Direction.ASC, "field"));
}

public Page<ENewspaperModel> pagingWithField(int offset, int pagesize, String field) {
	return repo.findAll(PageRequest.of(offset,pagesize, Sort.by(Sort.Direction.ASC, field)));
}

public List<ENewspaperModel> findAll() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public void  addPapers(ENewspaperModel model) {
	 repo.save(model);
	 
	// TODO Auto-generated method stub
	
}
}
