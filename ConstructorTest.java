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
	 * ����һ����ʱ�����Ӹ��������й�����
	 */
	public static void main(String args[]) {
		// it will print 1 and 2
		Test test = new Test2();
	}
}
