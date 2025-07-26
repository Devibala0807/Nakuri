package com.interfaceElements;

public interface ProfileUpdate_Interface  {
	
	String xpath_profileclick = "//div[@class='nI-gNb-drawer__bars']";
	
	String xpath_updateprofile = "//a[contains(text(),'View & Update Profile')]";
	String xpath_clickupdate = "//em[@class='icon edit ']";
	String xpath_name = "(//input[@type='text'])[4]";
	String xpath_workstatus = "//label[contains(text(),'Experienced')]";
	String xpath_selectexpyrs = "//input[@placeholder='Select year']";
	String xpath_dropdownselect = "//a[@data-id='exp-years-droope_3']";
	String id_currentsalary = "totalAbsCtc_id";
	String xpath_salarybreakdown = "//input[@placeholder='Select salary components']";
	String xpath_fixedsalary = "(//a[contains(text(),'Fixed')])[1]";
	String id_saveprofile = "saveBasicDetailsBtn";
	
	


	

}
