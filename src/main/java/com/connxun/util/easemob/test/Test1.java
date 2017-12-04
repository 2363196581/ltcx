package com.connxun.util.easemob.test;

import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		Date date=new Date();
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -1);  
        date = calendar.getTime(); 
        System.out.println("date:"+date.getTime());
	}
	
}
