package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceElements.ProfileUpdate_Interface;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;



public class ProfileUpdatePage extends Base_Class implements ProfileUpdate_Interface  {
	
	@FindBy(xpath =xpath_profileclick)
	private WebElement clickprofile;
	
	@FindBy(xpath =xpath_updateprofile)
	private WebElement updateprofile;
	
	@FindBy(xpath =xpath_clickupdate)
	private WebElement clickupdate;
	
	@FindBy(xpath = xpath_name)
	private WebElement name;
	
	@FindBy(xpath = xpath_workstatus)
	private WebElement workstatus;
	
	@FindBy(xpath = xpath_selectexpyrs)
	private WebElement clickexpyrs;
	
	@FindBy(xpath = xpath_dropdownselect)
	private WebElement selectdropdown;
	
	@FindBy(id = id_currentsalary )
	private WebElement salary;
	
	@FindBy(xpath = xpath_salarybreakdown)
	private WebElement salarybreakdown;
	
	@FindBy(xpath = xpath_fixedsalary)
	private WebElement fixedsalary;

	
	@FindBy (id = id_saveprofile)
	private WebElement saveprofile;
	
	
	public ProfileUpdatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void updateProfile() throws IOException {
		explicitWait(clickprofile, 30);
		clickOnElement(clickprofile);
		explicitWait(updateprofile, 20);
		clickOnElement(updateprofile);
		explicitWait(clickupdate, 30);
		clickOnElement(clickupdate);
		clickOnElement(name);
		javaScriptSendKeys(name,PageObjectManager.getPageobjectmanager().getExcelldata().getCellValue("DATA","ID","Title"));
		clickOnElement(workstatus);
		explicitWait(clickexpyrs, 20);
		clickOnElement(clickexpyrs);
	    explicitWait(selectdropdown, 30);
		clickOnElement(selectdropdown);
		explicitWait(salary, 20);
		clickOnElement(salary);
		javaScriptSendKeys(salary, PageObjectManager.getPageobjectmanager().getExcelldata().getCellValue("DATA","ID","Salary"));
		explicitWait(salarybreakdown, 20);
		clickOnElement(salarybreakdown);
		explicitWait(fixedsalary, 20);
		clickOnElement(fixedsalary);
		clickOnElement(saveprofile);
		
		
	}

}
