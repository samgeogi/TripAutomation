package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is defined in order to find the web elements in Result Page
 * @author 875192
 *
 */

public class Result_Page {
public static WebElement element = null;
public static int totalFlightsAvl;
	
	public static WebElement priceSort(WebDriver driver) {
	 element =driver.findElement(By.linkText("Price"));
	 return element;
	}
	
	public static List<WebElement> price(WebDriver driver){
	 List<WebElement> list=driver.findElements(By.xpath("//div[3]//div[5]/strong"));
	 return list;
	}
	
	public static List<WebElement> flightName(WebDriver driver){
	 List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class, 'right_Airline_no')]"));
	 totalFlightsAvl=list.size();
	 return list;
	}

}
