package demo.generics;

import java.util.*;

class A {}
class B {}

public class OtherTest2<T> extends demo.BaseDemo 
{
	Class<T> kind;
	
	OtherTest2(Class<T> kind) {
		this.kind = kind;
	}
	public void f(Object obj) 
	{
		/*
		 * wrong : T is non-static type, can't make a static reference
		if (o instanceof T) {}  
		T var = new T();
		T[] array = new T[10];
		T[] array = (T)new Object[10];
		*/
		printf("%s is an instanceof %s? %s\n", obj, kind.getSimpleName(), kind.isInstance(obj));
	}
	
	public T create() { 
		try {
			return kind.newInstance();
		} catch (Exception e) {
			println("Exception : Abstract \\ Primitive \\ Array \\ No Fit Constructor");
			return null;
		}
	}
	// make ArrayList<T> is the best choice.
	public List<T> createArray(int size) {
		return new ArrayList<T>(size);
	}
	
	public static void main(String args[]) 
	{
		OtherTest2<Integer> test = new OtherTest2<Integer>(Integer.class);
		test.f(32);
		test.f("32");
		OtherTest2<String> test2 = new OtherTest2<String>(String.class);
		println("Create a new instance of string is \"\"? " + test.create().equals(""));
	}
	
	
}
