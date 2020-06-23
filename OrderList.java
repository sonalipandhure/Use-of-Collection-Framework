package tableexercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElements(By.xpath("//tr/td[2]")); //if its in xpath
		List<WebElement>firstColList =driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> originalList=new ArrayList<String>();
		for(int i=0; i<firstColList.size();i++)
		{
			System.out.println(firstColList.get(i).getText());
			originalList.add(firstColList.get(i).getText());
			
		}
		ArrayList<String> copiedList = new ArrayList<String>();
		for(int i=0;i<originalList.size();i++)
		{
			copiedList.add(originalList.get(i));
		}
		System.out.println("********Sorted Order********");
		Collections.sort(copiedList); //Collection framework in Java where we can use sort/reverse method
		Collections.reverse(copiedList);
		
		for(String s: copiedList)  //for(i=0;i<copiedList.size();i++)
		{
			System.out.println(s);
		}
		System.out.println("*******Original List********");
		for(String s: originalList)  //for(i=0;i<copiedList.size();i++)
		{
			System.out.println(s);
		}
	Assert.assertTrue (originalList.equals(copiedList));
	}

}
