package demo;

class PolymorphismTest extends BaseDemo {
	
	static class A {	
		void play() { println("A");	}
		void test() { println("test"); play(); }
	}

	static class B extends A {
		void play() { println("B");	}
	}
	
	abstract static class A2 {
		// abstract标识抽象方法，拥有抽象方法的类是抽象类，不可生成对象。
		// 可在继承中实现此功能
		abstract void play();		
		// it's not good to invoke function in constructor, 
		// something Unpredictable will happen.
		A2() { play(); }
	}
	static class B2 extends A2 {
		int count = 5;
		void play() { println(count); }
	}
	
	static class C {
		A test() { return new A(); }
	}
	static class D extends C {
		/*
		 * Although return type is not the same, it'll also override test().(non-Javadoc)
		 * that's call covariant return type ( B is a derived class of A )
		 */
		@Override
		B test() { return new B(); }
	}
	
	public static void main(String args[]) {
		A as[] = {new A(), new B()};
		for (A x : as)
			x.test();	// it will print: test A test B
		
		// will print 0 because "count" in B2 isn't initialized 
		// before play() print it.
		A2 a2 = new B2();
		
		// the type of t1 is A, t2 is B.
		A t1 = new C().test();
		A t2 = new D().test();
		t1.play();
		t2.play();		
	}
}