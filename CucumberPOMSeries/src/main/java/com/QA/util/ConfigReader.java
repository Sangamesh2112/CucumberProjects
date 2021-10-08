package com.QA.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	 
	/**
	 * this method is to load the properties from config.properties file
	 * @return it returns Properties Prop Project
	 */
	public Properties init_prop() 
	{
		prop = new Properties();
		try
		{
		FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties"); // For Reading config Properties
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
