package demo;

public class ClassTest {
	
	// 为了让static的main函数能调用此类，被迫全改为static的。
	static class A extends BaseDemo {
		void make(char x) {
			println("make(char)");
		}
		final void make(int x) {
			println("make(int)");
		}
		static void test(A x) {
			println("test");
		}
	}

	/*
	 * B is final means you can't 
	 * create any class extends B 
	 */
	static final class B extends A {
		void make(double x) {
			println("new make(double)");
		}
		/* @Override prevent reloading error */
		@Override
		void make(char x) {
			println("new make(char)");
		}
		/* can't override a "final" method
		 * void make(int x)
		 */
	}
	
	public static void main(String args[]) {
		B b = new B();
		b.make(3);		//make(int)
		b.make(3.0);	//new make(double)
		b.make('3');	//new make(char) // Override the base class method
		B.test(b);		//although it's B, but it can auto change to A(B's base class).
	}
}
