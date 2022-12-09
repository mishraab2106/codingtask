package com.project.codingtask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.codingtask.entity.DbModel;
import com.project.codingtask.repos.DbRepository;

@Service
public class ENewspaperService {
	
@Autowired
private DbModel model;
@Autowired
private DbRepository repo;

public List<DbModel>sortingWithField(String field) {
	return repo.findAll(Sort.by(field));
}

public Page<DbModel> pagingWithField(int offset, int pagesize, String field) {
	// TODO Auto-generated method stub
	return repo.findAll(PageRequest.of(offset, pagesize));
}
}
