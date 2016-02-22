package demo;

public class InnerClass extends BaseDemo {
	
	public class Inner {
		// .this to access outer class
		InnerClass getOuter() { return InnerClass.this; }
	}
	
	public void print() { println("success"); }
	
	static public void main(String args[]) {		
		InnerClass test = new InnerClass();
		// .new to create a inner class
		InnerClass.Inner inner = test.new Inner();
		inner.getOuter().print();
	}
}
