package MLL.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MLL.AbstractComponents.AbstractComponent;

public class PreGrnPageObjects extends AbstractComponent{

public WebDriver driver;
	
	public PreGrnPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()=' Create ']")
	private WebElement createBtn;
	
	
	
	public WebElement createButton()
	{
		return createBtn;
	}
	
	
	
	
	
	
}
