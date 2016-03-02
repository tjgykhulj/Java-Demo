package demo.generics;

public class TupleTest {
	
	// it's tuple, a group of objects wrapped together into a single object 
	class Two<A,B> {
		public final A first;
		public final B second;
		public Two(A a, B b) {
			first = a;
			second = b;
		}
	}
	// and longer-length tuples can be created with inheritance easily.  
	class Three<A,B,C> extends Two<A,B> {
		public final C third;
		public Three(A a, B b, C c) {
			super(a,b);
			third = c;
		}
	}
}
