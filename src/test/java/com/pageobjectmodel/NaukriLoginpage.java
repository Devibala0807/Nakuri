package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceElements.Naukri_Loginpage_Interface;
import com.pageobjectmanager.PageObjectManager;
import com.utility.FileReaderManager;

public class NaukriLoginpage extends Base_Class implements Naukri_Loginpage_Interface {
	@FindBy(linkText =login_linktext)
	private WebElement login;
	
	@FindBy(xpath =username_xpath)
	private WebElement username;
	
	@FindBy(xpath =password_xpath)
	private WebElement password;
	
	@FindBy(xpath =signin_xpath)
	private WebElement signin;
	
	public NaukriLoginpage() {
	 PageFactory.initElements(driver, this);
	}
	
	public void naukriLogin() throws IOException{
		//FileReaderManager data = new FileReaderManager();
		clickOnElement(login);
	   // passInput(username,PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("username"));
		//passInput(password,PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("password"));
		javaScriptSendKeys(username, PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("username"));
		javaScriptSendKeys(password, PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("password"));
		//waitConcepts(signin, "explicitWait", null);
		elementVisibilty(signin,"enabled");
		explicitWait(signin, 30);
		clickOnElement(signin);

	}
	
	

}
