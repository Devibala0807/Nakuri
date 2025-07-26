package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceElements.Education_Interface;
import com.pageobjectmanager.PageObjectManager;

public class EducationPage extends Base_Class implements Education_Interface{
	
	@FindBy(xpath = xpath_addeducation)
	private WebElement clickeducation;
	
	@FindBy (xpath = xpath_selecteducation)
	private WebElement selecteducation;
	
	@FindBy (xpath = xpath_selectgraduation)
	private WebElement graduation;
	
	@FindBy(id = id_university)
	private WebElement university;
	
	@FindBy(xpath = xpath_selectcourse)
	private WebElement course;
	
	@FindBy(linkText = linkText_clickcourse)
	private WebElement clickcourse;
	
	@FindBy(xpath = xpath_specialization)
	private WebElement clickspl;
	
	@FindBy (linkText = linText_selectspecial)
	private WebElement selectspl;
	
	@FindBy (xpath = xpath_coursetype)
	private WebElement coursetype;
	
	@FindBy (xpath = xpath_startyear)
	private WebElement startyear;
	
	@FindBy (linkText = linkText_pickvalue)
	private WebElement pickyear;
	
	@FindBy (xpath = xpath_endyear)
	private WebElement endyear;
	
	@FindBy (xpath = xpath_selectendyr)
    private WebElement pickendyear;
	
	@FindBy (id = id_saveeducation)
	private WebElement saveeducation;
	
	public EducationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addeducation() throws IOException {
		clickOnElement(clickeducation);
		explicitWait(selecteducation, 30);
		clickOnElement(graduation);
		javaScriptSendKeys(university, PageObjectManager.getPageobjectmanager().getExcelldata().getCellValue("DATA","ID","University"));
		clickOnElement(course);
		explicitWait(clickcourse, 20);
		clickOnElement(clickcourse);
		clickOnElement(clickspl);
		explicitWait(selectspl, 30);
		clickOnElement(selectspl);
		clickOnElement(coursetype);
		clickOnElement(startyear);
		explicitWait(pickyear, 30);
		clickOnElement(pickyear);
		clickOnElement(endyear);
		explicitWait(pickendyear, 20);
		clickOnElement(pickendyear);
		clickOnElement(saveeducation);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
