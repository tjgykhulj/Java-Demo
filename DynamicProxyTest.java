package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest extends BaseDemo
implements InvocationHandler {
	 
	private Object proxied;
	DynamicProxyTest(Object obj) {
		proxied = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable 
	{
		println("[before invoke] method :" + method);
		Object result = method.invoke(proxied, args);
		println("[finsih invoke] result : " + result);
		return result;
	}

	interface Test {
		void test1();
		int test2();
	}
	static class TestImpl implements Test {
		public void test1() { println("test1"); }
		public int test2() { println("test1"); return 2; }
	}
	public static void main(String[] args) {
		// Business Object
		Test obj = new TestImpl();
		// Proxy Object
		Test proxy = (Test) Proxy.newProxyInstance(
				TestImpl.class.getClassLoader(),
				TestImpl.class.getInterfaces(),
				new DynamicProxyTest(obj));		// Filter Object
		proxy.test1();
		proxy.test2();
	}
}
