package demo;

import java.util.*;

public class ClassTest3 extends BaseDemo {

	// inner-class must be static, or else it can't be "newInstance" 
	static class A {
		void printInfo() {
			println(this.getClass().getName());
		}
	}
	static class B extends A {}
	static class C extends A {}
	static class D extends B {}
	static class E extends C {}
	
	static private final List<Class<? extends A>> types = 
			Collections.unmodifiableList( Arrays.asList(
					A.class, B.class, C.class, D.class, E.class ));

	private Random random = new Random();
	
	A randomType() {
		int n = random.nextInt(types.size());
		try {
			return types.get(n).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String ar[]) {
		ClassTest3 test = new ClassTest3();
		A[] as = new A[5];
		for (A i : as) {
			i = test.randomType();
			i.printInfo();
		}
	}
}
