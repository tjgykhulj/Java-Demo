package demo.multithread;

public class RunnableTest 
{
	static class Test implements Runnable {
		// In sub-type of Runnable, it's easy to share resource
		int count = 0;
		@Override
		public void run() {
			for (int i=0; i<8; i++) 
				System.out.printf("%s : count is %d\n", Thread.currentThread().getName(), count++);
		}
	}
	
	public static void main(String args[]) {
		Test test = new Test();
		new Thread(test).start();
		new Thread(test).start();
	}
}
