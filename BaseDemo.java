package demo;

public class BaseDemo {
	/** a base class that contains some useful functions */
	public static void println(Object s) {
		System.out.println(s);
	}
	static void print(Object s) {
		System.out.print(s);
	}
	static void printArray(Object... args) {
		for (Object obj:args)
			System.out.print(obj + " ");
		System.out.println();
	}
}
