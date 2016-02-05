package demo;

public class ConstructorTest {
	static class Test extends BaseDemo {
		public static String parentStatic = "parent-static";
		public String parent = "parent";
		static {
			println(parentStatic);
		}
		{
			println(parent);
		}
		Test() {
			println("parentConstructor");
		}
	}
	static class Test2 extends Test {
		public static String childStatic = "child-static";
		public String child = "child";
		static {
			println(childStatic);
		}
		{
			println(child);
		}
		Test2() {
			println("childConstructor");
		}
	}
	
	/**
	 * ����һ����ʱ�����Ӹ��������й�����
	 * ����˳��Ϊ��static\��static\����ͨ\��������\����ͨ\�ӹ�������
	 * parent-static
	 * child-static
	 * parent
	 * parentConstructor
	 * child
	 * childConstructor
	 */
	public static void main(String args[]) {
		// it will print 1 and 2
		Test test = new Test2();
	}
}