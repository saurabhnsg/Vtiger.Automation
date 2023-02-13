package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "phone")
	public void addProductToCartTest(String brand, int price, String model )
	{
		System.out.println(brand + price + model);
	}
	
	@DataProvider(name = "phone")
	public Object[][] getData()
	{	
		Object [][] data= new Object[2][3];
		
		data[0][0]="samsung";
		data[0][1]= 2000;
		data[0][2]="S13";
		
		data[1][0]="apple";
		data[1][1]= 5000;
		data[1][2]="XR";
		
		return data;
	}
}

