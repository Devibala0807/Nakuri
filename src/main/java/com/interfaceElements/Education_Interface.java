package com.interfaceElements;

public interface Education_Interface {
	
	String xpath_addeducation = "//span[contains(text(),'Add education')]";
	String xpath_selecteducation = "//input[@placeholder='Select education']";
	String xpath_selectgraduation = "//a[contains(text(),' Graduation/Diploma ')]";
	String id_university = "institute";
	String xpath_selectcourse = "//input[@placeholder='Select course']";
	String linkText_clickcourse = " B.Tech/B.E. ";
	String xpath_specialization = "//input[@placeholder='Select specialization']";
	String linText_selectspecial = " Automobile ";
	String xpath_coursetype = "//label[contains( text(),'Full time')]";
	String xpath_startyear = "//input[@placeholder='Starting year']";
	String linkText_pickvalue = " 2016 ";
	String xpath_endyear = "//input[@placeholder='Ending year']";
	String xpath_selectendyr ="//a[@data-id='yopField_2020']";
	String id_saveeducation = "saveEducation";
	
	

}
