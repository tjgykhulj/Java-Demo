package demo;

public class InnerClass extends BaseDemo {
	
	public class Inner {
		// .this to access outer class
		InnerClass getOuter() { return InnerClass.this; }
	}
	
	public void print() { println("success"); }
	
	abstract class Contents {
		Contents(int x) { println(x); }
		abstract void print();
	}
	
	//Anonymous Inner Class
	public Contents getContents() {
		int x = 3;
		return new Contents(x) {
			void print() {
				println("print from anonymous");
			}
		};
	}
	
	// 继承类部类B的C，依然可以调用A的方法
	static class A {
		void show() { println("link succ");	}
		class B {
			A getOuter() { return A.this; }
		}
	}
	// extends inner-class should make a outer class object
	// in order to link outer-class
	static class C extends A.B {
		C(A x) {
			x.super();
			println("extends inner-class succ");
		}
	}
	static public void main(String args[]) {		
		InnerClass test = new InnerClass();
		// .new to create a inner class
		InnerClass.Inner inner = test.new Inner();
		inner.getOuter().print();
		
		Contents x = test.getContents();
		x.print();
		
		A a = new A();
		C c = new C(a);
		// to show that it can get A a
		c.getOuter().show();
	}
	
}