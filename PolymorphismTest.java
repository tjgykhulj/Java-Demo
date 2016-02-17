package demo;

public class PolymorphismTest extends BaseDemo {
	
	static class A {
		void play() {
			println("A");
		}
	}

	static class B extends A {
		void play() {
			println("B");
		}
	}
	static class C extends A {
		
	}
	
	public static void main(String args[]) {
		A a[] = {new A(), new B(), new C()};
		for (A x : a)
			x.play();	// it will print: A B A
	}
}
