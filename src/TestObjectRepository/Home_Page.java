package TestObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UserDefinedlibraries.FlightDate;

/**
 * This class is defined in order to find the web elements in Home Page
 * @author 875192
 *
 */
public class Home_Page {
public static WebElement element = null;

    public static WebElement searchboxFrom(WebDriver driver) {
    	element =driver.findElement(By.id("stationFrom"));
    	return element;
    }
    //To find the web element of the "from" city from suggestion box.
    public static WebElement fromOption(WebDriver driver){
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-1']/li[1]")));
    	element=driver.findElement(By.xpath("//*[@id='ui-id-1']/li[1]"));
    	return element;
    }
    
    public static WebElement searchboxTo(WebDriver driver) {
    	element =driver.findElement(By.id("stationTo"));
    	return element;
    }
    //To find the web element of the "to" city from suggestion box.
    public static WebElement toOption(WebDriver driver){
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-2']/li[1]")));
    	element=driver.findElement(By.xpath("//*[@id='ui-id-2']/li[1]"));
    	return element;
    }
    //To find web element of available months for travel
    public static WebElement monthYear(WebDriver driver) {
    	String monthval=FlightDate.month;
    	element =driver.findElement(By.xpath("//*[text()='"+monthval+"']"));
    	return element;
	}
    //To find web element of all the active dates in the month selected month
    public static List<WebElement> calenderDates(WebDriver driver){
    	List<WebElement> list1=driver.findElements(By.xpath("//*[@class='act']"));
    	return list1;
    }

    public static WebElement searchButton(WebDriver driver) {
    	element =driver.findElement(By.xpath("//div[2]/form/button"));
    	return element;
    }

}
