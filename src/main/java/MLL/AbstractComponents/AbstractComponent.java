package MLL.AbstractComponents;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

public WebDriver driver;
public String fileName;
public String ranCh;
public int rnd;

String propertyValue;

	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Inbound']")
	private WebElement InboundNavMenu;
	
	@FindBy(linkText="Pre GRN")
	private WebElement preGrn;
	
	@FindBy(linkText="GRN")
	private WebElement Grn;
	
	
	@FindBy(xpath="(//input[@placeholder='Search in table'])[1]")
	private WebElement searchValue;
	
	public void InboundNavMenuButton()
	{
		 InboundNavMenu.click();
	}
	
	public void preGrnNavButton() 
	{
		 preGrn.click();
	}
	
	
	public void GrnNavButton()
	{
		Grn.click();
	}
	
	public void searchTable(String value) throws InterruptedException
	{
		searchValue.sendKeys(value);
		searchValue.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		searchValue.clear();
		Thread.sleep(2000);
		searchValue.sendKeys("  ");
		searchValue.toString().trim();
		searchValue.sendKeys(Keys.ENTER);
		
	}
	
	

	public static String generateRandomNumb(int num) {
		String ranNum = RandomStringUtils.randomNumeric(num);
		return ranNum;
	}

	public String generateRandomStr(int count) {
		ranCh = RandomStringUtils.randomAlphabetic(count);

		return ranCh;
	}

	public static String generateRandomAlphaNumerics(int count) {

		String ranAn = RandomStringUtils.randomAlphanumeric(count);
		return ranAn;
	}

	public static Double generateRandomDecimalValues() {

		Random dice = new Random();
		Double decimalValues;

		decimalValues = 1 + dice.nextDouble();
		return decimalValues;
	}

	public static String randomConvertDecimalValues() {
		double decimalValues = generateRandomDecimalValues();
		String c = Double.toString(decimalValues);
		return c;
	}

	public int getRandom(int count) {
		rnd = new Random().nextInt(count);
		return rnd;
	}
	
	public void DropdownValues(WebElement ele, List<WebElement>options, String values, WebDriver driver)
			throws InterruptedException {
		
		// TODO Auto-generated method stub
		//WebElement ele = driver.findElement(By.xpath(dropdown));
		ele.click();
		Thread.sleep(2000);
	//	List<WebElement> options = driver.findElements(By.cssSelector(dropdownValue));
		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(values)) {
				option.click();
				break;
			}

		}
	}
	
	public void Dropdown(WebElement ele, List<WebElement>options, String values, WebDriver driver)
			throws InterruptedException {
		
		// TODO Auto-generated method stub
		//WebElement ele = driver.findElement(By.xpath(dropdown));
		ele.sendKeys("107");
		
		Thread.sleep(2000);
	//	List<WebElement> options = driver.findElements(By.cssSelector(dropdownValue));
		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(values)) {
				option.click();
				break;
			}

		}
	}
	
}
