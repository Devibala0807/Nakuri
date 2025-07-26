package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceElements.KeySkills_Interface;
import com.pageobjectmanager.PageObjectManager;

public class KeySkillsPage extends Base_Class implements KeySkills_Interface {
	
	@FindBy (xpath = xpath_clickkeyskill)
	private WebElement clickkey;
	
	@FindBy (xpath = xpath_addskills)
	private WebElement addskills;
	
	@FindBy (id = id_saveskills)
	private WebElement saveskills;
	
	public KeySkillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addKeySkills() throws IOException {
		clickOnElement(clickkey);
		javaScriptSendKeys(addskills,PageObjectManager.getPageobjectmanager().getExcelldata().getCellValue("DATA","ID","Key Skills"));
		clickOnElement(saveskills);
	}

}
