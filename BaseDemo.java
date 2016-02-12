package demo;

public class BaseDemo {
	/** a base class that contains some useful functions */
	static void println(Object s) {
		System.out.println(s);
	}
	static void printArray(Object... args) {
		for (Object obj:args)
			System.out.print(obj + " ");
		System.out.println();
	}
}
