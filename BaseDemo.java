package demo;

public class BaseDemo {
	/** a base class that contains some useful functions */
	public static void println(Object s) {
		System.out.println(s);
	}
	public static void print(Object s) {
		System.out.print(s);
	}
	public static void printf(String format, Object... obj) {
		System.out.printf(format, obj);
	}
	
	public static void printArray(Object... args) {
		for (Object obj:args)
			System.out.print(obj + " ");
		System.out.println();
	}
}
