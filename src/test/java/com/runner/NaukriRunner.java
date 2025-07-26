package com.runner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class NaukriRunner extends Base_Class {
	
	@Test
	public void propertySetup() throws IOException {
		
		browserLaunch(PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("browser"));
		launchUrl(PageObjectManager.getPageobjectmanager().getFilereader().getDataProperty("url"));
		PageObjectManager.getPageobjectmanager().getLoginnaukri().naukriLogin();
		PageObjectManager.getPageobjectmanager().getUpdateprofile().updateProfile();
		PageObjectManager.getPageobjectmanager().getHeadline().addHeadline();
		PageObjectManager.getPageobjectmanager().getKeyskillpage().addKeySkills();
		PageObjectManager.getPageobjectmanager().getEducationpage().addeducation();
		}
	
	

	
	
	

}
