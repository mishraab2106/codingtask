package com.project.codingtask.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.codingtask.entity.ENewspaperModel;
import com.project.codingtask.model.AppInfo;
import com.project.codingtask.model.DeviceInfo;
import com.project.codingtask.model.EpaperRequest;
import com.project.codingtask.model.GetPages;
import com.project.codingtask.model.OsInfo;
import com.project.codingtask.model.ScreenInfo;
import com.project.codingtask.service.ENewspaperService;

@ExtendWith(MockitoExtension.class)
public class ENewspaperControllerTest {
	
	@InjectMocks
	ENewspaperController enewspapercontroller;
	@Mock
	ENewspaperService service;
	@Test
	String addpaper() {
		
		ENewspaperController enewspapercontroller=new ENewspaperController();
	    EpaperRequest epaper=new EpaperRequest();
	    ENewspaperModel model=new ENewspaperModel();
	    DeviceInfo deviceinfo= new DeviceInfo();
	    AppInfo appinfo=new AppInfo();
	    GetPages getpages=new GetPages();
	    OsInfo osinfo=new OsInfo();
	    ScreenInfo screeninfo=new ScreenInfo();
	    
	    appinfo.setNewspaperName("abb");
	    screeninfo.setDpi(123);
	    screeninfo.setHeight(456);
	    screeninfo.setWidth(234);	    
	    deviceinfo.setScreenInfo(screeninfo);
	    epaper.setDeviceInfo(deviceinfo);		    
		String response=enewspapercontroller.addpaper(epaper);
		assertEquals("Saved Data successfully", response);
		return response;
}
	  @Test
	  String deletepapers() {
		ENewspaperController enewspapercontroller=new ENewspaperController();
		Long id=1L;
		String response=enewspapercontroller.deletepaper(id);
		return response;
	}
}
