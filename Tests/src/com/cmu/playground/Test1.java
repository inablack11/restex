package com.cmu.playground;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringEscapeUtils;

import com.thoughtworks.xstream.XStream;



public class Test1 {
	private boolean useCodeAsDefaultMessage = false;

	private boolean alwaysUseMessageFormat = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		runTest2();
//		doubleTests("321321.987654");
//		play1();
//		stringSplitter();
//		stringSetPlay();
		testIntAsParam();
	}

	private static void runTest1() {
		String testString = new String("a\newq\newqqweewq\nb");
		System.out.println("Before replace -> Size of string= >>" + testString + "<< is = " + testString.length());
		testString = testString.replaceAll("\n", " ");
		System.out.println("After replace -> Size of string= >>" + testString + "<< is = " + testString.length());
	}
	
	private static void runTest2() {
		
		System.out.println(StringEscapeUtils.escapeXml("<object-array>\n<long>7724788880052</long>\n</object-array>"));
		
		XStream xStream = new XStream();
		Object[] parameters = (Object[]) xStream.fromXML("<object-array>\n<long>7724788880052</long>\n</object-array>");
//		parameters[parameters.length] = new String("zz");
		System.out.println(parameters);
		
		for (int i=0; i<parameters.length; i++) {
			if (parameters[i] instanceof Integer || 
					parameters[i] instanceof BigInteger || 
					parameters[i] instanceof Long) {
				parameters[i] = parameters[i].toString();
			}
		}
		System.out.println(parameters[0] instanceof String ? "true": "false");		
		
	}
//	protected String getMessageInternal(String code, Object[] args, Locale locale) {
//		if (code == null) {
//			return null;
//		}
//		if (locale == null) {
//			locale = Locale.getDefault();
//		}
//		Object[] argsToUse = args;
//
//	
//			// Resolve arguments eagerly, for the case where the message
//			// is defined in a parent MessageSource but resolvable arguments
//			// are defined in the child MessageSource.
//			argsToUse = resolveArguments(args, locale);
//
//			MessageFormat messageFormat = resolveCode(code, locale);
//			if (messageFormat != null) {
//				synchronized (messageFormat) {
//					return messageFormat.format(argsToUse);
//				}
//			}
//
//	}
	
	private static void doubleTests(String input) {
		BigDecimal tempInput = new BigDecimal(input);
		System.out.println("test");
	}
	
	private static void play1() {
		int x, a=6, b=7;
		x= a++ + b++;
		System.out.println(x+"-"+a+"-"+b);
	}
	
	private static void stringSplitter() {
		String input = "6/12+/53;6/12+/52";
		String inputsSeparatedByOr[] = input.split(";");
		System.out.println("splitted");
		input = "6/12+/53";
		String inputSplitted[] = input.split("/");
		System.out.println("splitted 2");
	}
	
	
	public static void stringSetPlay() { 
	     int nisteValori[] = {7, 8, 1, 2, 3, 3, 4, 5, 6};
	     
	     Set<String> set = new HashSet<String>();
	     
	     try{
	        //adaug niste valori in set
	    	for(int i = 0; i<8; i++){
	           set.add(nisteValori[i] + " ");
	        }
	    	//afisez setul - elementele nu sunt ordonate in set
	        System.out.println("Afisez elementele din set. Acestea nu sunt ordonate: " + set);
	        
	        
	        //folosesc un iterator pentru a parcurge setul
	        Iterator<String> iterator = set.iterator();
	        System.out.print("Afisez elementele din set, parcurgandu-l cu Iterator: ");
	        while (iterator.hasNext()) {
				System.out.print(iterator.next());				
			}
	        
	        //afisez elem din set parcurgandu-l cu for
	        System.out.print("\nAfisez elementele din set, parcurgandu-l cu for: ");
	        for(String elem : set) {
	        	System.out.print(elem);	
	        }
	
	  
	  
	        //treeSet-ul le sorteaza in ordine "naturala" - toate elem tre sa implem Comparable si sa fie comparabile ca tip de date
	        TreeSet<String> sortedSet = new TreeSet<String>(set);
	        System.out.print("\nElementele din Set puse intr-un TreeSet. Vor fi sortate in ordine naturala: ");
	        System.out.println(sortedSet);

	        System.out.println("Primul elem din TreeSet: " + (String)sortedSet.first());
	        System.out.println("Ultimul elem din TreeSet: " + (String)sortedSet.last());
	     }
	     catch(Exception e){}
	  }
	
	public static void testIntAsParam() {
		int value = 0;
		incrementInt(value);
		System.out.println(">>>>testIntAsParam.value="+value);
		

		Integer valueInteger = new Integer(0);
		incrementInteger(valueInteger);
		System.out.println(">>>>testIntegerAsParam.valueInteger="+valueInteger);
	}

	private static void incrementInt(int value) {
		value++;
		System.out.println(">>>>incrementInt.value="+value);
	}

	private static void incrementInteger(Integer valueInteger) {
		valueInteger++;
		System.out.println(">>>>incrementInteger.valueInteger="+valueInteger);
	}

	
}
