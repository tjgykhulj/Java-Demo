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
		
	static public void main(String args[]) {		
		InnerClass test = new InnerClass();
		// .new to create a inner class
		InnerClass.Inner inner = test.new Inner();
		inner.getOuter().print();
		
		Contents x = test.getContents();
		x.print();
	}
	
}