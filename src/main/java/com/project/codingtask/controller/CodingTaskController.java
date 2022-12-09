
package com.project.codingtask.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.project.codingtask.entity.DbModel;
import com.project.codingtask.model.EpaperRequest;
import com.project.codingtask.repos.DbRepository;




@RestController
public class CodingTaskController {

@Autowired
private DbRepository repo;
@Autowired
private DbModel model;


@PostMapping(value="/papers",produces = {"application/json"})
List<DbModel> epaper(@RequestBody EpaperRequest ePaperRequest) {

	model.setDpi(ePaperRequest.getDeviceInfo().getScreenInfo().getDpi());
	model.setHeight(ePaperRequest.getDeviceInfo().getScreenInfo().getHeight());
	model.setWidth(ePaperRequest.getDeviceInfo().getScreenInfo().getWidth());
	model.setUploadtime(LocalTime.now().toString());
	model.setFilename("epaper.xml" +"-"+LocalTime.now());
	model.setNewspapername(ePaperRequest.getDeviceInfo().getAppInfo().getNewspaperName());
	System.out.println(LocalTime.now());
	repo.save(model);
	return repo.findAll();
}
@GetMapping(value="/papers/{field}",produces = {"application/json"})
List<DbModel> epaper1(@PathVariable String field){
	return repo.findAll(Sort.by(field));
}

@GetMapping(value="/papers/{offset}/{pagesize}",produces = {"application/json"})
List<DbModel> epaper1(@PathVariable int offset,@PathVariable int pagesize){
	List<DbModel> paper= (List<DbModel>) repo.findAll(PageRequest.of(offset, pagesize));
	 return paper;
}






}
