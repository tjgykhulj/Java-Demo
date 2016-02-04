package demo;

public class EqualsTest extends BaseDemo {

	static class Test {
		int x;
	}
	
	static class Test2 extends Test {
		Test2(int x) {
			this.x = x;
		}
		
		@Override
		public boolean equals(Object b) {
			return x == ((Test)b).x;
		}
	}
	
	public static void main(String[] args) 
	{
		/** Integer内的整数相等
		 * 但Integer这类非基本类型的==操作，
		 * 比较的是内容存放的地址，即c++的引用 */
		Integer a = new Integer(4);
		Integer b = new Integer(4);
		println(a==b);		//false
		println(a.equals(b)); //true

		/** Java中若不覆盖equals方法
		 * 默认是比较引用的地址，与==操作相同 */
		Test c = new Test();
		c.x = 4;
		Test d = new Test();
		d.x = 4;
		println(c==d);			//false
		println(c.equals(d));	//false
		

		/** 在Test2中新加入equals覆盖掉原有的
		 * 得到预期结果 */
		Test e = new Test2(3);
		Test f = new Test2(3);
		println(e==f);			//false
		println(e.equals(f));	//true
	}
}
