package com.gslab.ab;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.util.Date;

public class WorkOnDateFormat {
	
	public static void main(String[] args) {
		
		String s= "2012-09-09 15:12:00";
		String S = s.substring(0, 10);
		System.out.println(S);
		Date date = new Date();
		System.out.println(date);
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		long startDate = today.atStartOfDay().toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();
		System.out.println(startDate);
		
		Format formatter1 = new SimpleDateFormat("dd MMM yyyy");
	    System.out.println( formatter1.format(new Date()) );
	    
	    Format formatter2 = new SimpleDateFormat("EEEE,dd MMMM yyyy");
	    System.out.println( formatter2.format(new Date()) );
	    
	    // Date difference
	    LocalDate endofCentury = LocalDate.of(2019, 04, 20);
        LocalDate now = LocalDate.now(); // 2019 - 04 - 25
        Period diff = Period.between(endofCentury, now);
        System.out.println(diff); // P5D  => 5 days
	}

}
