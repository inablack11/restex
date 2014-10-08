package com.cmu.designpatterns;

import java.util.Random;


public class Test2 {
	
	private static ConverterFactory converterFactory = new ConverterFactory();
	
	public static void main(String[] args) throws Exception {

		for(int i=0; i<=100; i++) {
			playConverters(new String("template" + randomTest(1, 5)), new String("server1"));
		}
	}

	private static void playConverters(String template, String server) throws Exception {
		IConverter converter = converterFactory.getConverterInstance(template, server);
		converter.printClassDetails();
		
	}
	
	public ConverterFactory getConverterFactory() {
		return converterFactory;
	}
	
	public static int randomTest(int start, int end){
		Random random = new Random();
        int randomNumber = random.nextInt(end - start) + start; 
        return randomNumber;

	}
	
}
