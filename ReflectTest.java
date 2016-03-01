package demo;

import java.lang.reflect.*;

@SuppressWarnings("unused")
class A {
	int get() { return a; }
	private int a = 3;
	private void privateMethod() {
		System.out.println("You can't invoke it from outside.");
	}
}

public class ReflectTest extends BaseDemo
{
	
	public static void main(String ar[]) throws Exception {
		A test = new A();
		println("Is A.a safe? a = " + test.get());
		
		// access private int a
		Field f = A.class.getDeclaredField("a");
		f.setAccessible(true);
		f.setInt(test, 1);
		println("After set, a = " + test.get());
		
		// invoke private method
		Method g = A.class.getDeclaredMethod("privateMethod");
		g.setAccessible(true);
		g.invoke(test);
	}
}
