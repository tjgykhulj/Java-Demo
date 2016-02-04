package demo;


public class OtherTest extends BaseDemo {

	public static void main(String[] args) {
		/** 
		 * From a to b is Widening, so the cast is not required. 
		 * From b to a is Narrowing. */
		int a = 3;
		long b = a;
		int c = (int) b;
		
		int t;
		/** can't get t now, because it has no a initialize. 
		 * Sample: println(t); */
		for (int i=0; i<10; i++) {
			/**can't define an existing variable, like t
			 * Sample: int t = 0; */
		}
	}
}
