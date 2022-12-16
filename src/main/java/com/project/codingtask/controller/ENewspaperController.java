
package com.project.codingtask.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.DeleteMapping;
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
       String  addpaper(@Valid @RequestBody EpaperRequest ePaperRequest) 
  {
	 model.setDpi(ePaperRequest.getDeviceInfo().getScreenInfo().getDpi());
	 model.setHeight(ePaperRequest.getDeviceInfo().getScreenInfo().getHeight());
	 model.setWidth(ePaperRequest.getDeviceInfo().getScreenInfo().getWidth());
	 model.setUploadtime(LocalTime.now().toString().substring(0,8));
	 model.setFilename("epaper.xml" +"-"+LocalTime.now().toString().substring(0,8));
	 model.setNewspapername(ePaperRequest.getDeviceInfo().getAppInfo().getNewspaperName());																																				
	 service.addPapers(model);
	 return "Data has been saved successfully";
  }

@DeleteMapping("/deletepapers")
  public String deletepaper(@RequestParam Long id) {
	  service.deletepaper(id);
	  return "Deleted enewspaper with id " +id;	
}
@GetMapping(value="/filtersortpapers",produces = {"application/json"})
  List<ENewspaperModel> filtersortpapers(@RequestParam(value="sort_by",defaultValue="uploadtime") String sort,
		@RequestParam(value="filename",defaultValue="") String filename,
		@RequestParam(value="height",defaultValue="") String height,
		@RequestParam(value="width",defaultValue="") String width, 
		@RequestParam(value="newspapername",defaultValue="") 
        String newspapername,@RequestParam(value="offset",defaultValue="0") int offset,
        @RequestParam(value="pagesize",defaultValue="10") int pagesize,
        @RequestParam(value="dpi",defaultValue="") Integer dpi,
        @RequestParam(value="uploadtime",defaultValue="") String uploadtime)


  {
	  if(!newspapername.equals("")) {
		return service.newspaperfilterWithPagination(newspapername,offset,pagesize,sort);
   }
	  else if(!filename.equals("")) {
		return service.filenamefilterWithPagination(filename,offset,pagesize,sort);
   }
	  else if(!width.equals("")) {
		int width1=Integer.parseInt(width); 
		return service.widthfilterWithPagination(width1,offset,pagesize,sort);
   }
	  else if(!height.equals(""))
   {    int height1=Integer.parseInt(height);
        return service.heightfilterWithPagination(height1,offset,pagesize,sort);	
   }  else if(dpi!=null) 
   {
	    return service.dpifilterWithPagination(dpi,offset,pagesize,sort);
   }  else 	   
	     return service.uploadtimefilterWithPagination(uploadtime, offset, pagesize, sort);
   }
   }
