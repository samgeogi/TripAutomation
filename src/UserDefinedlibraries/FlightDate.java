package UserDefinedlibraries;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
/**
 * This class is defined to find the travel date
 * @author 875192
 * @since 2020-11-02
 */
public class FlightDate {
	public static String dayWeek=(ExcelReadWrite.dayWeek).toUpperCase();
	public static String month;
	public static String day;
	public  static void nextWeek() {
		  LocalDate now = LocalDate.now();  
		  LocalDate travelDate=null;
		  //to get the date for the day of week specified in excel
		  switch (dayWeek){
		  	case "MONDAY":
		  		travelDate= now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		  		break;
		  	case "TUESDAY":
		  		travelDate= now.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		  		break;
		  	case "WEDNESDAY":
		  		travelDate= now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		  		break;
		  	case "THURSDAY":
		  		travelDate= now.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
				break;
		  	case "FRIDAY":
		  		travelDate= now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
				 break;
		  	case "SATURDAY":
		  	     travelDate= now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
				 break;
		  	case "SUNDAY":
		  	     travelDate= now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
				 break;
		   }
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
	 String flightDate = travelDate.format(formatter);
	 //flightDate  obtained is split to get month and day.
	 String[] flightDateSplit=new String[2];
	 flightDateSplit = flightDate.split("-");
	 month=flightDateSplit[1];
	 String str=flightDateSplit[0];
	 String strPattern = "^0+(?!$)";
     day = str.replaceAll(strPattern, "");
	}
	
}
