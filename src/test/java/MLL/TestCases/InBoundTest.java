package MLL.TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import MLL.PageObjects.LoginPageObjects;
import MLL.PageObjects.NewPreGrnPageObjects;
import MLL.PageObjects.PreGrnPageObjects;
import MLL.TestComponents.BaseTest;
import MLL.TestComponents.PageObjectManager;


public class InBoundTest extends BaseTest{
	
	public LoginPageObjects loginPageObjects;
	public String retriveValue=null;	
	public PageObjectManager pageObjectManager;
	public boolean status;
	

	
	@Test(dataProvider = "getData")
	public void PreGrncreate(HashMap<String, String> input) throws InterruptedException {
		pageObjectManager=new PageObjectManager(driver);
		System.out.println("before login");
		loginScreen(input);	
		Thread.sleep(4000);
		System.out.println("test after login in Pregen");
		
		pageObjectManager.getNewPreGrnPageObjects().InboundNavMenuButton();
		
		pageObjectManager.getNewPreGrnPageObjects().preGrnNavButton();
		Thread.sleep(10000);
		pageObjectManager.getNewPreGrnPageObjects().createPreGrnBtn();
		Thread.sleep(3000);
		pageObjectManager.getNewPreGrnPageObjects().typeDropDown();
		Thread.sleep(3000);
		pageObjectManager.getNewPreGrnPageObjects().invoicetb();
		String retriveValue = pageObjectManager.getNewPreGrnPageObjects().retriveValues();
		this.retriveValue=retriveValue;
		pageObjectManager.getNewPreGrnPageObjects().supplierDropDown(supplier);
		Thread.sleep(3000);
		pageObjectManager.getNewPreGrnPageObjects().selectCurrentDay();
		Thread.sleep(2000);
		pageObjectManager.getNewPreGrnPageObjects().refNotb();
		pageObjectManager.getNewPreGrnPageObjects().selectItemCode(ItemCodeValue);
		Thread.sleep(2000);
		pageObjectManager.getNewPreGrnPageObjects().itemStatusDropDown(ItemStatus);
		Thread.sleep(2000);
		pageObjectManager.getNewPreGrnPageObjects().UOMDropDown(UOMValue);
		Thread.sleep(2000);
		pageObjectManager.getNewPreGrnPageObjects().qtytb();
		pageObjectManager.getNewPreGrnPageObjects().save();
		Thread.sleep(2000);
		pageObjectManager.getNewPreGrnPageObjects().BackButton();
		
	}
	

	
	@Test
	public void PreGrnsearch() throws InterruptedException
	{
		 Thread.sleep(3000);
		 pageObjectManager.getPreGrnPageObjects().searchTable(retriveValue);
	}

	@Test(dependsOnMethods = { "PreGrncreate" })
	public void GrnSearch() throws InterruptedException
	{
		Thread.sleep(3000);
		pageObjectManager.getGrnPageObjects().GrnNavButton();
		Thread.sleep(10000);
		pageObjectManager.getGrnPageObjects().searchTable(retriveValue);
		String invoiceValue=pageObjectManager.getGrnPageObjects().getInvoiceNoValue();
		Assert.assertEquals(retriveValue, invoiceValue);
		
				
	}
	
	@Test(dependsOnMethods = { "GrnSearch" })
	public void convertToGrn() throws InterruptedException
	{
		Thread.sleep(2000);
		pageObjectManager.getGrnPageObjects().clickConvertGrnBtn();
		Thread.sleep(3000);
		pageObjectManager.getGrnPageObjects().selectAllCheckBoxx();
		pageObjectManager.getGrnPageObjects().clickCerateGrnBtn();
	}
	
	 
	
}
