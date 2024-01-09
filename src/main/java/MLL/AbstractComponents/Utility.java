package MLL.AbstractComponents;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {

	public String fileName;

	public String propertyValue;
	public void setFileInputValue(String fileName)
	{
		this.fileName=fileName;
	}
	
	public String getPropertyValue(String property)
	{
		Properties prop= new Properties();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop.load(fis);
			propertyValue=prop.getProperty(property);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return propertyValue;
		
	}
}
