package demo.annotation;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;

import demo.BaseDemo;

public class Test1 {

	private static void println(Object s) {
		System.out.println(s);
	}
	
	class Demo {
		public int value = 3;
		// will not be outputed in this case
		@Override
		protected void finalize() {
			System.out.println("in finalize");
		}
	}

	// JUNIT can run every public function return void
	// if there's a public non-parameters constructor in that class
	class C {
		int a, b;
		
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
	}
	@Test
	public void work() throws Exception {
		println("work");
		Object c = new C();
	}

	@Test
	public void work2() {
		Demo x = new Demo();
		Assert.assertEquals(1, x.value);
		println("work2");
	}

	// before\after every test
	@Before public void before() { println("[before]"); }
	@After public void after() { println("[after]");}
	// before\after all tests in this class
	@BeforeClass public static void begin() { println("[[begin]]"); }
	@AfterClass public static void end() { println("[[end]]"); }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
