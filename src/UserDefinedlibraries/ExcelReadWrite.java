package UserDefinedlibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * This class is defined to implement Excel read and write
 * @author 875192
 * @since 2020-11-02
 * 
 */
public class ExcelReadWrite {
public static File src;
public static String exfilepath = "C:\\Users\\sam\\eclipse-workspace\\TripAutomation\\src\\Datatables\\Flightdata.xlsx";
public static FileInputStream fileip;
public static FileOutputStream fileop;
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static String val1;
public static int row;
public static XSSFCell cell;
public static XSSFRow Row;
public static String currentCity;
public static String destinationCity;
public static String travelDate;
public static String dayWeek;
public static int numberOfFlights;

	public static int readexcel() throws IOException {
		try
		{
			src=new File(exfilepath);
			fileip = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileip);
			sheet = workbook.getSheetAt(0);
			for(int i=2; i<=sheet.getLastRowNum(); i++){
				if(i==2){
					currentCity = (sheet.getRow(i).getCell(0)).getStringCellValue();
					destinationCity = (sheet.getRow(i).getCell(1)).getStringCellValue();
					dayWeek =(sheet.getRow(i).getCell(2)).getStringCellValue();
					numberOfFlights=(int)(sheet.getRow(i).getCell(3)).getNumericCellValue();
					System.out.println("Excel read values");
					System.out.println("From City: "+currentCity);
					System.out.println("To city: "+destinationCity);
					System.out.println("Day of Week: "+dayWeek);
					System.out.println("number of flight details: "+numberOfFlights);
					row=i;
					break;
				}
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return row;
		}

	public static void writeexcel() {
		try
		{
			//Close input stream
			fileip.close();
			//Create an object of FileOutputStream class to create write data in excel file
			fileop =new FileOutputStream(new File(exfilepath));
			//write data in the excel file
			workbook.write(fileop);
			//close output stream
			fileop.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}