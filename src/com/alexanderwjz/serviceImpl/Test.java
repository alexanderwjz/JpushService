package com.alexanderwjz.serviceImpl;

import java.io.FileInputStream;
import java.util.Properties;

public class Test {
	public static void main(String[] agrs){
		Properties pp=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("src/pushinfo.properties");
			pp.load(fis);
			String APP_KEY=pp.getProperty("APP_KEY");
			String MASTER_SECRET=pp.getProperty("MASTER_SECRET");
			System.out.println("appkey="+APP_KEY +"master_secret="+MASTER_SECRET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
