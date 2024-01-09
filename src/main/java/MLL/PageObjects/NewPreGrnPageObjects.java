package MLL.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MLL.AbstractComponents.AbstractComponent;

public class NewPreGrnPageObjects extends AbstractComponent{

public WebDriver driver;
	
	public NewPreGrnPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#controlibpgType")
	private WebElement type;
	
	private String typeValue="RECEIVE PO";
	
	@FindBy(css=".mat-option-text")
	private List<WebElement> listDropDownValues; 
	
	@FindBy(xpath="//input[@placeholder='invoiceNo']")
	private WebElement invoiceNo;
	
	@FindBy(css="#controlsupplierId")
	private WebElement supplier;
	
	
	@FindBy(xpath="//input[@placeholder='ibRef']")
	private WebElement ibRefNo;
	
	@FindBy(xpath="//input[@placeholder='itemCode']")
	private WebElement itemCode;
	
	@FindBy(xpath="//mat-select[@ng-reflect-name='itemStatusId']")
	private WebElement itemStatus;
	
	@FindBy(xpath="//mat-select[@ng-reflect-name='uomId']")
	private WebElement UOM;
	
	@FindBy(xpath="//input[@placeholder='ibQty']")
	private WebElement ibQty;
	
	
	@FindBy(xpath="(//button[@aria-label='Open calendar'])[5]")
	private WebElement openCalender;
	
	@FindBy(css=".mat-calendar-body-today")
	private WebElement calenderValue;
	
	@FindBy(xpath="//span[text()='Create PreGrn']")
	private WebElement createPreGrn;
	
	@FindBy(xpath="//span[text()='Back']")
	private WebElement backBtn;
	
	public PreGrnPageObjects createPreGrnBtn()
	{
		PreGrnPageObjects preGrnPageObjects=new PreGrnPageObjects(driver);
		preGrnPageObjects.createButton().click();
		return preGrnPageObjects;
	}
	public void typeDropDown() {
		try {
			DropdownValues(type,listDropDownValues,typeValue, driver);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String invoicetb()
	{
		String invValue="inv"+generateRandomStr(5)+"Auto";
		invoiceNo.sendKeys(invValue);
		return invValue;
	}
	
	public String retriveValues()
	{
		String retriveValue=invoiceNo.getAttribute("value");
		return retriveValue;
		
	}
	
	public void supplierDropDown(String value) {
		try {
			DropdownValues(supplier,listDropDownValues,value, driver);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void selectCurrentDay() throws InterruptedException
	{
		openCalender.click();
		Thread.sleep(2000);
		calenderValue.click();
	}
	
	public String refNotb()
	{
		String RefValue="ibRef"+generateRandomStr(5)+"Auto";
		ibRefNo.sendKeys(RefValue);
		return RefValue;
	}
	
	public void selectItemCode(String code)
	{
		
		try {
			Dropdown(itemCode,listDropDownValues,code, driver);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void itemStatusDropDown(String value) {
		try {
			DropdownValues(itemStatus,listDropDownValues,value, driver);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void UOMDropDown(String value) {
		try {
			DropdownValues(UOM,listDropDownValues,value, driver);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void qtytb()
	{
		String qtyValue=generateRandomNumb(1);
		ibQty.sendKeys(qtyValue);
	}
	
	
	public void save()
	{
		createPreGrn.click();
	}
	
	public void BackButton()
	{
		backBtn.click();
	}
}
