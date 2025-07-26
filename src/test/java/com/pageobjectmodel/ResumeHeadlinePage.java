package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceElements.ResumeHeadline_Interface;
import com.pageobjectmanager.PageObjectManager;

public class ResumeHeadlinePage extends Base_Class implements ResumeHeadline_Interface {
	
	@FindBy(xpath = xpath_clickresheadline)
	private WebElement clickheadline;
	
	@FindBy (xpath = xpath_addtext)
	private WebElement addtext;
	
	public ResumeHeadlinePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void addHeadline() throws IOException {
		clickOnElement(clickheadline);
		clickOnElement(addtext);
		javaScriptSendKeys(addtext,PageObjectManager.getPageobjectmanager().getExcelldata().getCellValue("DATA","ID","Resume headline"));
	}
	

}
