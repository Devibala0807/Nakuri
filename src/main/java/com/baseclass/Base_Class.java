package com.baseclass;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Base_Class {
	
	public static WebDriver driver;
	public static ExtentReports extentReports;
	public static File file;
	public static Alert alert;
	public static Actions actions;
	public static Select select;
	public static JavascriptExecutor javaScriptExecutor;
//Browser Launch	
	protected static WebDriver browserLaunch(String browserName) {
		try {
			
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
		    }else if (browserName.equalsIgnoreCase("firefox")) {
		    	driver = new FirefoxDriver();
		    }else if (browserName.equalsIgnoreCase("edge")) {
		    	driver = new EdgeDriver();
            }
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING BROWSERLAUNCH");
			
		}
		driver.manage().window().maximize();
		return driver;
		}
//Close Browser
	protected static void closeBrowser(String type) {
		try {
			if (type.equalsIgnoreCase("close")) {
				
				driver.close();
			}else if (type.equalsIgnoreCase("quit")) {
				
				driver.quit();
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLOSING BROWSER");
		}
	}
	
//Navigate To
	protected static void navigateTo(String url) {
		try {
				driver.navigate().to(url);
					
				
		} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING NAVIGATING BROWSER");
			}
	}
//Navigate Options
	protected static void navigateOptions(String type) {
			try {
				if (type.equalsIgnoreCase("forward")) {
					driver.navigate().forward();
				}else if (type.equalsIgnoreCase("back")) {
					driver.navigate().back();
				}else if (type.equalsIgnoreCase("refresh")) {
					driver.navigate().refresh();
				}
			}
			catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING NAVIGATING OPTIONS");
			}
	}
//Launch URL
	protected static void launchUrl(String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING LAUNCHING URL");
			}
			
		}
//Alert
	protected static void alertOptions(String type) {
		try {
			if (type.equalsIgnoreCase("accept")) {
				alert = driver.switchTo().alert();
				alert.accept();
			}else if (type.equalsIgnoreCase("dismiss")) {
			    alert = driver.switchTo().alert();
				alert.dismiss();
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ALERT OPTIONS");
		}
	}
//Prompt Alert
	protected static void passInputToAlert(String value) {
		try {
			alert = driver.switchTo().alert();
			alert.sendKeys(value);
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING VALUE PASSING TO ALERT");
		}
	}
	
	protected static void getAlertText() {
		try {
		    alert = driver.switchTo().alert();
			alert.getText();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETTING TEXT FROM TEXT");
		}
	}
//Actions
	protected static void actionsOptions(WebElement element,String type) {
		try {
			 actions = new Actions(driver);
			if (type.equalsIgnoreCase("click")) {
				actions.click(element).perform();;
			}else if (type.equalsIgnoreCase("contextclick")){
				actions.contextClick(element).perform();;
			}else if (type.equalsIgnoreCase("doubleclick")) {
				actions.doubleClick(element).perform();
			}else if (type.equalsIgnoreCase("movetoelement")) {
				actions.moveToElement(element);
			}else if (type.equalsIgnoreCase("clickandhold")) {
				actions.clickAndHold().perform();
			}else if (type.equalsIgnoreCase("release")) {
				actions.release().perform();
			}
		
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ALERT OPTIONS");
		}
	}
//Drag and Drop
	protected static void dragAndDropActions(WebElement source,WebElement target) {
		try {
			actions.dragAndDrop(source, target).perform();
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING DRAG AND DROP");
		}
	}
//Frame
	protected static void frameOptions(WebElement element,String type,String value) {
		try {
			if (type.equalsIgnoreCase("value")) {
				driver.switchTo().frame(value);
			}else if (type.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("element")) {
				driver.switchTo().frame(element);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING FRAME OPTIONS");
		}
	}
//Window Handling
	protected static void getWindowHandles(int num) {
		try {
			List<String> allWindows = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindows.get(num));
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING WINDOW HANDLING");
		}
	}
//Drop Down Select
	protected static void selectOptions(WebElement element,String type,String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING VALUE SELECT");
		}
	}
//Drop Down Deselect
	protected static void deselectOptions(WebElement element,String type,String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING VALUE DESELECT");
		}
	}
//Click,checkbox,Radio button
	protected static void clickOnElement(WebElement element) {
		try {
			element.click();
			} catch (Exception e) {
			  Assert.fail("ERROR: OCCUR DURING CLICK ON ELEMENT");
			}
	}
	
	protected static void elementVisibilty(WebElement element,String type) {
		try {
			if (type.equalsIgnoreCase("enabled")) {
				boolean enabled = element.isEnabled();
				System.out.println(enabled);
			}else if (type.equalsIgnoreCase("selected")) {
				boolean selected = element.isSelected();
				System.out.println(selected);
			}else if (type.equalsIgnoreCase("displayed")) {
				boolean displayed = element.isDisplayed();
				System.out.println(displayed);
			}
			
		} catch (Exception e) {
			 Assert.fail("ERROR: OCCUR DURING IS OPTIONS");
		}
	}
//SendKeys
	protected static void passInput(WebElement element,String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			 Assert.fail("ERROR: OCCUR DURING PASSING INPUT");
		}
	}
//Get
	protected static void getOptions(WebElement element) {
		try {
			
			List<WebElement> allOptions = select.getOptions();
			for (WebElement name : allOptions) {
				String text = name.getText();
				System.out.println(text);
			}
			
		} catch (Exception e) {
			 Assert.fail("ERROR: OCCUR DURING GET OPTIONS");
		}
	}
	protected static void getValue(WebElement element,String type,String value) {
		try {
			if (type.equalsIgnoreCase("getText")) {
				String text = element.getText();
				System.out.println(text);
			}else if (type.equalsIgnoreCase("getAttribute")) {
				Object attribute = element.getAttribute(value);
			}
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GET VALUE");
		}
	}
//Robot
		
	protected static void keyBoardActions(String type) {
		try {
			Robot robot = new Robot();
			if (type.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING KEYBOARD ACTIONS");
		}
		
	}

		
	
//Screenshot
	protected static void screenshot() {
		try {
			Date currentdate = new Date();
			System.out.println(currentdate);
			String datefile = currentdate.toString().replace(" ", "_").replace(":", "_");
			  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileHandler.copy(screenshot, new File(".//Screenshot//"+datefile+".png"));
			
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SCREENSHOT");
		}
		
	}
//JavaScript Executor
	protected static void javaScriptSendKeys(WebElement element,String value) {
		try {
		javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("arguments[0].value=arguments[1];", element,value);
		} catch (Exception e) {
			Assert.fail("ERROR OCCURED DURING JAVA SCRIPT EXECUTOR SENDKEYS");
		}
	}


    protected static void javaScriptClick(WebElement element) {
    	try {
	javaScriptExecutor = (JavascriptExecutor)driver;
	javaScriptExecutor.executeScript("arguments[0].click;", element);
    } catch (Exception e) {
    	       Assert.fail("ERROR OCCURED DURING JAVA SCRIPT EXECUTOR CLICK");   
    }    
    }
    protected static void scrollDown(int pixels) {
		javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.scrollBy(0," +pixels+")","");
		
	}
    
    protected static void scrollUp(int pixels) {
		javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,-" +pixels+")","");
		
		
	}
    
    protected static void horizontalRight(int pixels) {
		javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.scrollBy(arguments[0],0)",pixels);
		
		
	}
   // protected static void ValidationAssert() {
    	 //  Assert.assertEqu
    //}
    
    protected static void verificationAssert(WebElement act,String exp) {
    	    SoftAssert soft = new SoftAssert();
    	    soft.assertEquals(act.getText(), exp);
    	    System.out.println("VERIFICATION DONE");
    }
    
 // IMPLICIT WAIT
 	protected static void implicitWait(int duration) {
 		try {
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

 		} catch (Exception e) {
 			Assert.fail("ERROR OCCURED IN IMPLICIT WAIT METHOD");
 		}
 	}

 // EXPLICIT WAIT
 	protected static void explicitWait(WebElement element, int duration) {
 		try {
 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
 			wait.until(ExpectedConditions.visibilityOf(element));

 		} catch (Exception e) {
 			Assert.fail("ERROR OCCURED IN EXPLICIT WAIT METHOD");
 		}
 	}
 	
 	protected static void extentReportStart(String location) {
    	try {
    		extentReports = new ExtentReports();
    		file = new File(location);
    		ExtentSparkReporter sparkRepoter = new ExtentSparkReporter(file);
    		extentReports.attachReporter(sparkRepoter);
    		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    		
    		
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR EXTENT REPORT");
		}
    }
    
    protected static  void extentReportTearDown(String location) {
		try {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR EXTENT REPORT TEAR DOWN");
		}

	}
    protected static String takeScreenShot() {
		
		File destfile = null;
		try {
			TakesScreenshot screenshot =  (TakesScreenshot)driver;
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
			destfile = new File("Screenshot\\.png" + "_" + timeStamp + ".png" );
			FileHandler.copy(scrfile, destfile);
		} catch (WebDriverException e) {
			Assert.fail("ERROR: OCCUR DURING SCREENSHOT");
			
			e.printStackTrace();
		} catch (IOException e) {
			Assert.fail("ERROR: OCCUR DURING SCREENSHOT");
			e.printStackTrace();
		}
		
	
	return destfile.getAbsolutePath();
 	
 	
}

}

	


		
