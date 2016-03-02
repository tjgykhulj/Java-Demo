package demo.generics;

import java.util.*;

// ����ɼ���
class New {
	// Ҫ������<T>����
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
		// ��Ȼ�������ص���ArrayList����
		println(test.get(1).getClass().getName());
	}
	public static void main(String a[]) 
	{
		Map<Integer, A> test = New.map();
		test.put(1, new B());
		test.put(1, new A());
		// ����˵ֻ�ܸ�ֵ�����ֱ�ӽ�New.map()���뺯����New.map()�ķ���ֵ�ᱻ����Object����
		// Ȼ��ʵ�ʱ�ʾ���ص���HashMap���ͣ�û�г��ֹ���
		f(New.map());
	}
}
