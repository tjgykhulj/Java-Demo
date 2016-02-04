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
		/** Integer�ڵ��������
		 * ��Integer����ǻ������͵�==������
		 * �Ƚϵ������ݴ�ŵĵ�ַ����c++������ */
		Integer a = new Integer(4);
		Integer b = new Integer(4);
		println(a==b);		//false
		println(a.equals(b)); //true

		/** Java����������equals����
		 * Ĭ���ǱȽ����õĵ�ַ����==������ͬ */
		Test c = new Test();
		c.x = 4;
		Test d = new Test();
		d.x = 4;
		println(c==d);			//false
		println(c.equals(d));	//false
		

		/** ��Test2���¼���equals���ǵ�ԭ�е�
		 * �õ�Ԥ�ڽ�� */
		Test e = new Test2(3);
		Test f = new Test2(3);
		println(e==f);			//false
		println(e.equals(f));	//true
	}
}
