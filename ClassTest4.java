package demo;

import java.util.*;

public class ClassTest4 extends HashMap<Class<?>, Integer> 
{
	/**
	 * get(xx) will return the number of xx and xx's subtype
	 */
	private static final long serialVersionUID = 1L;
	private Class<?> baseType;
	
	public ClassTest4(Class<?> baseType) {
		this.baseType = baseType;
	}
	
	// it will test and update it
	private boolean testClass(Class<?> type) {
		if (baseType.isAssignableFrom(type)) {
			countClass(type);
			return true;
		}
		return false;
	}
	
	public void countClass(Class<?> type) {
		Integer val = get(type);
		put(type, val == null ? 1 : val + 1);
		testClass(type.getSuperclass());
	}


	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if (!testClass(type))
			throw new RuntimeException(obj + " : incorrect type : " + type +
					". should be type or subtype of " + baseType);
	}
	
	class A {}
	class B extends A {}
	class C extends A {}
	class D extends B {}
	class E extends C {}
	
	public static void main(String ar[]) {
		ClassTest4 test = new ClassTest4(A.class);
		test.count(test.new B());
		test.count(test.new D());
		test.count(test.new E());
		Class<?> types[] = { A.class, B.class, C.class, D.class, E.class };
		// get(A.class) == 3, because B\D\E are sub-types of A.
		// get(B.class) == 2, because B and D will be counted.
		for (Class<?> i : types)
			System.out.println(i + " : " + test.get(i));
	}
}
