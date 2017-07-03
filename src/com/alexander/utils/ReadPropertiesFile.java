package com.alexander.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class ReadPropertiesFile {
	/**
	 * @author alexanderwjz
	 * @email 1666796947@qq.com
	 * @function 该类用于读取极光用户的APP_KEY, MASTER_SECRET
	 **/
	public ReadPropertiesFile(){
		readprotery();
	}
	String APP_KEY;
	String MASTER_SECRET;
	//URL url=ClassLoader.getSystemClassLoader().getResource("ReadPropertiesFile.java");
	public String getAPP_KEY() {
		return APP_KEY;
	}
	public void setAPP_KEY(String aPP_KEY) {
		APP_KEY = aPP_KEY;
	}
	public String getMASTER_SECRET() {
		return MASTER_SECRET;
	}
	public void setMASTER_SECRET(String mASTER_SECRET) {
		MASTER_SECRET = mASTER_SECRET;
	}
	public void readprotery(){
		Properties pp=new Properties();
		FileInputStream fis=null;
		try {
			String  filePath=Thread.currentThread().getContextClassLoader().getResource("pushinfo.properties").getPath();
			filePath = URLDecoder.decode(filePath,"utf-8");
			System.out.println(filePath);
			fis=new FileInputStream(filePath);
			pp.load(fis);
			APP_KEY=pp.getProperty("APP_KEY");
			System.out.println(APP_KEY);
			MASTER_SECRET=pp.getProperty("MASTER_SECRET");
			System.out.println(MASTER_SECRET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}
