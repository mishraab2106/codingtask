package com.project.codingtask.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="ENewspaper")
public class DbModel {



@Id
@Column(name="uploadtime")
private String uploadtime;
 

@Column(name="width")
private int width;
@Column(name="height")
private int height;
@Column(name="dpi")
private int dpi;

@Column(name="newspapername")
private String newspapername;

@Column(name="filename")
private String filename;





public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getDpi() {
	return dpi;
}
public void setDpi(int dpi) {
	this.dpi = dpi;
}




public String getUploadtime() {
	return uploadtime;
}
public void setUploadtime(String uploadtime) {
	this.uploadtime = uploadtime;
}
public String getNewspapername() {
	return newspapername;
}
public void setNewspapername(String newspapername) {
	this.newspapername = newspapername;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}

	
}
