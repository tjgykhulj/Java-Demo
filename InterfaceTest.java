package demo;

// if something is a base class, it should be a interface  
public class InterfaceTest extends BaseDemo {
	// all method in interface will be public (default) 
	interface CanWalk { void walk(); }
	interface CanRun extends CanWalk { void run(); }
	interface CanSwim { void swim(); }
	interface test extends CanWalk, CanRun, CanSwim {
		// interface can extends multiply
	}
	static class Normal {
		public void walk() { println("walk"); }
		public void run() { println("run"); }
	}
	static class Hero extends Normal
	implements CanRun, CanSwim {
		public void swim() { println("swim"); }
	}
}
