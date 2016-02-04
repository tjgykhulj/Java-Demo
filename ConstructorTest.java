package demo;

public class ConstructorTest {
	static class Test extends BaseDemo {
		Test() {
			println(1);
		}
	}
	static class Test2 extends Test {
		Test2() {
			println(2);
		}
	}
	
	/**
	 * 创建一个类时，将从父到子运行构造器
	 */
	public static void main(String args[]) {
		// it will print 1 and 2
		Test test = new Test2();
	}
}
