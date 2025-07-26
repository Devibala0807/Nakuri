package com.pageobjectmanager;

import com.pageobjectmodel.EducationPage;
import com.pageobjectmodel.KeySkillsPage;
import com.pageobjectmodel.NaukriLoginpage;
import com.pageobjectmodel.ProfileUpdatePage;
import com.pageobjectmodel.ResumeHeadlinePage;
import com.utility.ExcelUtility;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private static PageObjectManager pageobjectmanager;
	private FileReaderManager filereader;
	private NaukriLoginpage loginnaukri;
	private ProfileUpdatePage updateprofile;
	private ExcelUtility excelldata;
	private ResumeHeadlinePage headline;
	private KeySkillsPage keyskillpage;
	private EducationPage educationpage;
	



	public EducationPage getEducationpage() {
		if (educationpage == null) {
			educationpage = new EducationPage();
			
		}
		return educationpage;
	}



	public KeySkillsPage getKeyskillpage() {
		if (keyskillpage == null) {
			keyskillpage = new KeySkillsPage();
			
		}
		return keyskillpage;
	}



	public ResumeHeadlinePage getHeadline() {
		if (headline == null) {
			headline = new ResumeHeadlinePage();
		}
		return headline;
	}



	public ExcelUtility getExcelldata() {
		if(excelldata == null) {
			excelldata = new ExcelUtility();
		}
		return excelldata;
	}



	public PageObjectManager() {
	}
	
	
	
	public static PageObjectManager getPageobjectmanager() {
		if (pageobjectmanager == null) {
			pageobjectmanager = new PageObjectManager();
			
		}
		return pageobjectmanager;
	}
	
	
	public NaukriLoginpage getLoginnaukri() {
		if (loginnaukri == null) {
			loginnaukri = new NaukriLoginpage();
			}
		return loginnaukri;
	}
	
	
	public FileReaderManager getFilereader() {
		if ( filereader== null) {
				filereader = new FileReaderManager(); 
			}
		return filereader;
	}
	public ProfileUpdatePage getUpdateprofile() {
		if (updateprofile == null) {
			updateprofile = new ProfileUpdatePage();
			
		}
		return updateprofile;
	}
	
	
	

}
