package demo.generics;

import java.util.*;

// 此类可记下
class New {
	// 要先申明<T>类型
	public static <T> List<T> list() { return new ArrayList<T>(); }
	public static <T> Set<T> set() { return new HashSet<T>(); }
	public static <K,T> Map<K,T> map() { return new HashMap<K,T>(); }
}

public class MethodTest extends demo.BaseDemo {
	static class A { }
	static class B extends A {}

	static void f(Map<Integer, List<? extends A>> test) {
		println(test.getClass().getName());
		test.put(1,  New.list());
		// 依然正常返回的是ArrayList类型
		println(test.get(1).getClass().getName());
	}
	public static void main(String a[]) 
	{
		Map<Integer, A> test = New.map();
		test.put(1, new B());
		test.put(1, new A());
		// 书上说只能赋值，如果直接将New.map()代入函数，New.map()的返回值会被当成Object类型
		// 然而实际表示返回的是HashMap类型，没有出现故障
		f(New.map());
	}
}
