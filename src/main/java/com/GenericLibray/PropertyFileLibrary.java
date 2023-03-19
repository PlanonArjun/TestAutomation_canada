package com.GenericLibray;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IconstanceLibrary.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}

}
