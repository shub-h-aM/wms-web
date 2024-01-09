package MLL.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MLL.AbstractComponents.AbstractComponent;

public class GrnPageObjects extends AbstractComponent{

public WebDriver driver;
	
	public GrnPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Convert to Grn']")
	private WebElement convertGrn;
	
	@FindBy(css=".mat-checkbox-inner-container")
	private WebElement checkbox;

	@FindBy(xpath="//span[text()='Create GRN']")
	private WebElement createGrn;
	
	@FindBy(xpath="//table[@class='mat-table-style mat-table']/tbody/tr/td[4]")
	private WebElement invoiceNoLists;
	
	
	public void clickConvertGrnBtn()
	{
		convertGrn.click();
	}
	
	public void selectAllCheckBoxx()
	{
		checkbox.click();
	}
	
	public void clickCerateGrnBtn()
	{
		createGrn.click();
	}
	
	public String getInvoiceNoValue()
	{
		String value=invoiceNoLists.getText();
		return value;
	}
}
