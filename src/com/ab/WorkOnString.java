package com.gslab.ab;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class WorkOnString {

	public static void main(String[] args) {
		
	    String response = "{\"customer_id\":\"k\",\"api_key\":\"0d2abcbd59d74df585047b2bec4d7df3\"}";
		String messege = response.replace("\\", "");
		System.out.println(messege);

		String wasted_ri = "wasted_ri";
		String ri_recommendation = "ri_recommendation";

		if (wasted_ri.toLowerCase().indexOf("ri") != -1)
			System.out.println("I found the keyword");

		if (ri_recommendation.toLowerCase().indexOf("ri") != -1)
			System.out.println("I found the keyword");

		if ("wastedri".toLowerCase().indexOf("ri") != -1)
			System.out.println("I found the keyword");
	    
	    String cot = "cot";
	    System.out.println(cot.equalsIgnoreCase("COT"));
	    System.out.println("COT".equalsIgnoreCase(cot));
	    
	    String one = "cot";
		System.out.println("COT".equalsIgnoreCase(one));
		
		String two = "COT";
		System.out.println("COT".equalsIgnoreCase(two));
		
		String result = WorkOnString.check();
		System.out.println(result);
	}
	
	@SuppressWarnings("unused")
	public static String check() {
		
		String s1 = null;
		String s2 = null;
		String s3 = "c";
		
		
		
		if(s3==null) {
			if(s2==null) {
				if(s1==null) {
					return "Result not found";
				}else {
					return s1;
				}
			}else {
				return s2;
			}
		}else {
			return s3;
		}
		
	}
}
