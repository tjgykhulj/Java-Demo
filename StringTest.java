package demo;

import java.util.Formatter;

public class StringTest extends BaseDemo {
	
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		String s = "ABCDEFG";
		// create a char[], contains all character of s
		char c[] = s.toCharArray();
		print("s is ");
		for (int i=0; i<s.length(); i++) print(c[i]);
		print("\n");
		
		String test = "AC";
		//  -1 if s<test, 0 if s==test, 1 if s>test
		println("s vs AC : " + s.compareTo(test));
		
		println("s == abcdefg(if not case sensitive) : " + s.equalsIgnoreCase(test));
		println("s is start with 'ABC'? " + s.startsWith("ABC"));
		println("s is start with 'ABC'? " + s.endsWith("ABC"));
		
		println("search DE in s : " + s.indexOf("DE"));
		println("search de in s : " + s.indexOf("de"));
		
		println("s change to low case : " + s.toLowerCase());
		println("from char[] to string : " + String.valueOf(c));
		
		// System.out.printf() is the same to printf in c++
		printf("%s\n", s);
		// format from String:
		String lang = "Java";
		System.out.println(String.format("Test Formatter in %s.", lang));
		// or you can:
		Formatter f = new Formatter(System.out);
		f.format("Test Formatter in %s.\n", lang);
	}
}