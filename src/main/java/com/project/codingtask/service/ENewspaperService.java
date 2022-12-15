package com.project.codingtask.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;
import com.project.codingtask.entity.ENewspaperModel;
import com.project.codingtask.repos.DbRepository;
import com.project.codingtask.repos.SpringJdbc;

@Service
public class ENewspaperService {
	
@Autowired
private ENewspaperModel model;
@Autowired
private DbRepository repo;
@Autowired
private SpringJdbc springjdbc;

public Page<ENewspaperModel> sortingWithPagination(int offset, int pagesize, String sortby) {
    Page<ENewspaperModel> newspaper=repo.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(sortby)));
    return newspaper;
}

public void deletepaper(Long id) {
	// repo.deletepaperById(id);
	repo.deleteById(id);
}

public List<ENewspaperModel> findAll() {
	return repo.findAll();
}

public void  addPapers(ENewspaperModel model) {
	 repo.save(model);	
}

public List<ENewspaperModel> newspaperfilterWithPagination(String newspapername,int offset,int pagesize,String sortby)
{
	Pageable pageable = PageRequest.of(offset, pagesize).withSort(Sort.by(sortby));;
	return repo.findBynewspapernameContainingIgnoreCase(newspapername, pageable).getContent();	
}

public List<ENewspaperModel> heightfilterWithPagination(int height, int offset, int pagesize,String sortby ) {
	return springjdbc.findByheightContaining(height, offset, pagesize, sortby);
	
}

public List<ENewspaperModel> widthfilterWithPagination(int width, int offset, int pagesize,String sortby) {
	return springjdbc.findBywidthContaining(width, offset, pagesize, sortby);
}
public List<ENewspaperModel> dpifilterWithPagination(int dpi, int offset, int pagesize,String sortby) {
	return springjdbc.findBydpiContaining(dpi, offset, pagesize, sortby);
}

public List<ENewspaperModel> filenamefilterWithPagination(String filename, int offset, int pagesize,String sortby) {
	Pageable pageable = PageRequest.of(offset, pagesize).withSort(Sort.by(sortby));
	return repo.findByfilenameContainingIgnoreCase(filename, pageable).getContent();
}
public List<ENewspaperModel> uploadtimefilterWithPagination(String uploadtime, int offset, int pagesize,String sortby) {
	Pageable pageable = PageRequest.of(offset, pagesize).withSort(Sort.by(sortby));
	return repo.findByuploadtimeContainingIgnoreCase(uploadtime, pageable).getContent();
}
}
