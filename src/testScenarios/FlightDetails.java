package testScenarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestObjectRepository.Home_Page;
import TestObjectRepository.Result_Page;
import UserDefinedlibraries.DriverSetup;
import UserDefinedlibraries.ExcelReadWrite;
import UserDefinedlibraries.FlightDate;
import UserDefinedlibraries.ScreenShot;

/**
 * This class is defined in order to implement
 * the given test scenarios of Trip Automation
 * Separate methods are defined to execute at priorities
 * according to the execution flow of different test cases
 * @author 875192
 * @since 2020-11-02
 */
public class FlightDetails extends DriverSetup {
	public static XSSFWorkbook workbook ;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static int numFlights;
	public static String browser,price[];
	public static String flight[];
	public static File src;
    public static int t;
    public static WebDriver driver;


    @Parameters("browser")
    @BeforeClass
    public void driverconfig(String browser)
    {
    	driver=DriverSetup.driverInstantiate(browser);
    }

    @Test(priority=1)
    public void testcaseRexl() throws IOException, FileNotFoundException
    {
    	ExcelReadWrite.readexcel();
    }

    @Test(priority=2)
    public void testcaseFrom(){
    	Home_Page.searchboxFrom(driver).sendKeys(ExcelReadWrite.currentCity);
    	Home_Page.fromOption(driver).click();
    }

    @Test(priority=3)
    public void testcaseTo(){
    	Home_Page.searchboxTo(driver).sendKeys(ExcelReadWrite.destinationCity);
    	Home_Page.toOption(driver).click();
    }

    @Test(priority=4)
    public void testcaseDate(){
    	FlightDate.nextWeek();
    	Home_Page.monthYear(driver).click();
    	String trdate=FlightDate.day;
    	//from all active dates to select the travel date
    	for(WebElement ele:Home_Page.calenderDates(driver)){
    		String date=ele.getText();
    		date=date.replaceAll("\\s.*", "");
    		if(date.equalsIgnoreCase(trdate)){
    			ele.click();
    		}
    	}
    }

    @Test(priority=5)
    public static void screenshotHome()throws IOException
    {
    	ScreenShot.screenShotTC(driver,"Home_Page-"+DriverSetup.browsertype);
    }

    @Test(priority=6)
    public void testcaseSearch(){
    	Home_Page.searchButton(driver).click();
    }

    @Test(priority=7)
    public static void testcasePriceSort(){
    	Result_Page.priceSort(driver).click();
    }

	@Test(priority=8)
	public static void screenshotResult()throws IOException {
		ScreenShot.screenShotTC(driver,"Result_Page-"+DriverSetup.browsertype);
	}

	@Test(priority=9)
	public static void testcaseFlight(){
		Result_Page.flightName(driver);
		//The output number of flight details is the minimum of value defined in excel or the total flights available in the result page
		numFlights=Math.min(ExcelReadWrite.numberOfFlights,(Result_Page.totalFlightsAvl));
		flight=new String[numFlights];
		for(int i=0;i<numFlights;i++){
			flight[i]=(Result_Page.flightName(driver).get(i).getText());	
		}
	}

	@Test(priority=10)
	public static void testcasePrice(){
		price=new String[numFlights];
		for(int i=0;i<numFlights;i++){
			price[i]=(Result_Page.price(driver).get(i).getText());	
		}
	}

	@Test(priority=11)
	public static void flightintoexcel() throws IOException, FileNotFoundException {
		t=ExcelReadWrite.row;
		if(DriverSetup.browsertype.equalsIgnoreCase("chrome")){
			for(int i=0;i<numFlights;i++){
				cell = ExcelReadWrite.sheet.createRow(t+i+1).createCell(4);
				cell.setCellValue((String)flight[i]);
			}
		}
		else if(DriverSetup.browsertype.equalsIgnoreCase("firefox")){
			for(int j=0;j<numFlights;j++){
				cell = ExcelReadWrite.sheet.getRow(t+j+1).createCell(6);
				cell.setCellValue((String)flight[j]);
			}
		}
		ExcelReadWrite.writeexcel();
	}

	@Test(priority=12)
	public static void priceintoexcel() throws IOException, FileNotFoundException {
		if(DriverSetup.browsertype.equalsIgnoreCase("chrome")){
			for(int i=0;i<numFlights;i++){
				cell = ExcelReadWrite.sheet.getRow(t+i+1).createCell(5);
				cell.setCellValue((String)price[i]);
			}
		}
		else if(DriverSetup.browsertype.equalsIgnoreCase("firefox")){
			for(int j=0;j<numFlights;j++){
				cell = ExcelReadWrite.sheet.getRow(t+j+1).createCell(7);
				cell.setCellValue((String)price[j]);
			}
		}
		ExcelReadWrite.writeexcel();
	}



	@AfterClass
	public void driverexit() {
		DriverSetup.driverClose();
	}
	
}
