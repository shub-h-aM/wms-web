package MLL.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MLL.AbstractComponents.AbstractComponent;

public class LoginPageObjects extends AbstractComponent{

	public WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	 WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passWord;
	
	@FindBy(css=".log_in_bt ")
	WebElement loginBtn;
	
	@FindBy(css=".splash_box_title")
	List<WebElement> warehouseList;
	
	

	public void loginApplication(String un, String pw) throws InterruptedException {
		
		userName.sendKeys(un);
		passWord.sendKeys(pw);
		loginBtn.click();
	}

//	public void goTo() {
//		driver.get("https://logipickqa.mlldev.com/login");
//	}
	
	public void selectWarehouse()
	{
		System.out.println("Inside the warehouse method");
		System.out.println(warehouseList);
		for(WebElement warehouseLists:warehouseList)
		{
			System.out.println("Inside the for loop");
			if(warehouseLists.getText().equalsIgnoreCase("ACE TRURTLE BLR"))
			{
				System.out.println(warehouseLists.getText());
				warehouseLists.click();
				break;
			}
		}
	}
	
}
