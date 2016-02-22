package demo;

public class InterfaceTest extends BaseDemo {
	// all method in interface will be public (default) 
	interface CanRun { void run(); }
	interface CanJump { void jump(); }
	interface CanSwim { void swim(); }
	static class Normal {
		public void run() { println("run"); }
		public void jump() { println("jump"); }
	}
	static class Hero extends Normal 
	implements CanRun, CanJump, CanSwim	{
		public void swim() { println("swim"); }
	}
}
