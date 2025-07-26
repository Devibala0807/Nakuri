package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.baseclass.Base_Class;
import com.interfaceElements.ITSkills_Interface;

public class ITSkillsPage extends Base_Class implements ITSkills_Interface {
	
	@FindBy (xpath = xpath_additskills)
	private WebElement addskills;
	
	@FindBy (id = id_softwarename)
	private WebElement softwarename;
	
	@FindBy (id = id_version)
	private WebElement version;
	
	@FindBy (xpath = xpath_experience)
	private WebElement experience;
	
	@FindBy (xpath = xpath_selectexp)
	private WebElement selectexp;
	
	

}
