package MLL.TestComponents;

import org.openqa.selenium.WebDriver;

import MLL.PageObjects.GrnPageObjects;
import MLL.PageObjects.NewPreGrnPageObjects;
import MLL.PageObjects.PreGrnPageObjects;

public class PageObjectManager{

	public WebDriver driver;
	public NewPreGrnPageObjects newPreGrnPageObjects;
	public PreGrnPageObjects preGrnPageObjects;
	public GrnPageObjects grnPageObjects;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public NewPreGrnPageObjects getNewPreGrnPageObjects() 
	{
		newPreGrnPageObjects=new NewPreGrnPageObjects(driver);
		return newPreGrnPageObjects;
	}
	
	public PreGrnPageObjects getPreGrnPageObjects()
	{
		preGrnPageObjects=new PreGrnPageObjects(driver);
		return preGrnPageObjects;
	}
	
	
	public GrnPageObjects getGrnPageObjects()
	{
		grnPageObjects=new GrnPageObjects(driver);
		return grnPageObjects;
	}
	
	
}

