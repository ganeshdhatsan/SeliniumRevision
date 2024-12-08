package DateFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class AllDateFunctions {
	
	@Test
	private void dateUsage() {

		/*
		 * create an object for Date
		 * 
		 */
		Date actualDateFormat = new Date();

		System.out.println("current date -->  " + actualDateFormat); // current date --> Sat Jun 15 07:10:24 IST 2024

		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		String newDateFormate = simple.format(actualDateFormat); // newDateFormate --> 15/06/24 07:10:24
		System.out.println("newDateFormate --> " + newDateFormate);

		String finalDate = newDateFormate.replaceAll("/", "").replaceAll(" ", "").replaceAll(":", "");
		System.out.println("finalDate --> " + finalDate);

		String name = "fileName" + finalDate + ".png";

		System.out.println(name);

	}

}
