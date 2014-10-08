package com.cmu.designpatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ConverterFactory {
	
	private static String settingInformation;
	/**
	 * static instance
	 */
	private Map<String, IConverter> instances = new HashMap<String, IConverter>();

	/**
	 * will give you a ready configured instance of the converter.
	 * 
	 * @param conversionTemplateFileName the file with the definition of the conversion
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ArticlePassException
	 */
	public IConverter getConverterInstance(String conversionTemplateFileName, String serverName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (conversionTemplateFileName == null || serverName == null) {
			throw new IllegalArgumentException("Parameters must not be null");
		}

		if (settingInformation == null) {
			settingInformation = new String(serverName);
		}

		
		if (!instances.containsKey(conversionTemplateFileName)) {
			System.out.println("Building Converter for " + conversionTemplateFileName);
			
			//determine at runtime the name of the converter class to initialize
			String converterClassName = getConverterClass();
			IConverter iCon = (IConverter)Class.forName(converterClassName).newInstance();
			iCon.init(conversionTemplateFileName, serverName);
			
			instances.put(conversionTemplateFileName, iCon);
			
		}

		IConverter converter = instances.get(conversionTemplateFileName);
		return converter;

	}

	private String getConverterClass() {

		//One option is to use a System Property that defines the name of the Bar implementation class; 
		//another is to read a config file; 
		//a third is to get the class name from a database;
		return pickRandomConverter();
	}
	
	private String pickRandomConverter() { 

        Random random = new Random();
        int randomNumber = random.nextInt(3 - 1) + 1; 
        if(randomNumber == 1) 
        	return "com.cmu.designpatterns.Converter1";
        else 
        	return "com.cmu.designpatterns.Converter2";
    }

}
