
package com.project.codingtask.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.project.codingtask.entity.ENewspaperModel;
import com.project.codingtask.model.EpaperRequest;
import com.project.codingtask.repos.DbRepository;
import com.project.codingtask.service.ENewspaperService;




@RestController
public class ENewspaperController {

@Autowired
private ENewspaperModel model;
@Autowired
private ENewspaperService service;


@GetMapping(value="/allpapers",produces = {"application/json"})
List<ENewspaperModel> epaper1(){
return service.findAll();																																																																																															
}

@PostMapping(value="/addpapers", consumes="application/xml")
String  epaper(@Valid @RequestBody EpaperRequest ePaperRequest) {

	model.setDpi(ePaperRequest.getDeviceInfo().getScreenInfo().getDpi());
	model.setHeight(ePaperRequest.getDeviceInfo().getScreenInfo().getHeight());
	model.setWidth(ePaperRequest.getDeviceInfo().getScreenInfo().getWidth());
	model.setUploadtime(LocalTime.now().toString());
	model.setFilename("epaper.xml" +"-"+LocalTime.now());
	model.setNewspapername(ePaperRequest.getDeviceInfo().getAppInfo().getNewspaperName());																																				
	service.addPapers(model);
	return "Data has been saved successfully";
}
@GetMapping(value="/sortpapers",produces = {"application/json"})
List<ENewspaperModel> epaper1(@RequestParam(value="width") String width){
	System.out.println(width);
	return service.sortingWithField(width);																																																																																															
}

@GetMapping(value="/papers",produces = {"application/json"})
List<ENewspaperModel> epaper1(@RequestParam(value="offset") int offset,@RequestParam(value="pagesize") int pagesize,@RequestParam(value="sort")  String sort){
	return service.pagingWithField(offset,pagesize,sort).getContent();
}







}
