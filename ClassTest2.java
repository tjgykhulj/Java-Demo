package demo;

public class ClassTest2 extends BaseDemo {
	
	interface A {}
	interface B {}
	
	class Toy {}
	class FacyToy extends Toy implements A, B {
		
	}
	
	// Class<?> means anything is ok.
	void printInfo(Class<?> c) {
		println("Class name is " + c.getName());
		println("SImple name is " + c.getSimpleName());
		println("Canonical name is " + c.getCanonicalName());
		println("c is an Interface? : " + c.isInterface());
		println("[done]");
	}
	public static void main(String args[]) 
	{
		ClassTest2 test = new ClassTest2();
		// or Class.forName("demo.ClassTest2$FacyToy");
		// A.class相比Class.forName("A")，后者将必定载入类，前者会有一定隋性
		Class<?> x = FacyToy.class;
		test.printInfo(x);
		for (Class<?> face : x.getInterfaces()) test.printInfo(face);
		Toy x2[] = new FacyToy[]{};
		test.printInfo(x2.getClass());
	}
}
