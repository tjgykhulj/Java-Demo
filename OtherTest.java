package demo;


public class OtherTest extends BaseDemo {

	public static void main(String[] args) {
		/** 
		 * From a to b is Widening, so the cast is not required. 
		 * From b to a is Narrowing. */
		{
		int a = 3;
		long b = a;
		int c = (int) b;
		println(c);
		}

		/** can't get t if there's no initialize. */
		{
		int t;
		// println(t); is wrong
		for (int i=0; i<10; i++) {
			/**can't define an existing variable, like t */
			 // int t = 0; is wrong
		}
		}
		
		{
		/**
		 * any opt with char\byte\short will result in "int".
		 * so (z+1) should be cast to char. 
		 */
		char a = 'a';
		a = (char) (a+1);
		println(a);	//print b
		}
		
		{
		/** foreach sample */
		int a[] = new int[3];
		for (int i=0; i<3; i++) a[i]=i;
		for(int x : a) println(x); 
		}
		
		{
		/** label sample
		 * break label will break the whole literal (include below "while (true)"
		 * continue label will continue the loop where the label is 
		 * (in here is "for j ..") */
		long sum = 0;
		label:
			for (int j=0; ; j++) {
				for (int i=0; ; i++) { 
					if (i==5)
						if (sum>30) break label;
						else continue label;
					sum += i;
					println(i+" "+sum+" "+j);
				}
			}
		}
	}
}
