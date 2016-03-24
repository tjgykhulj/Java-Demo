package demo.multithread;

public class RunnableTest 
{
	int count = 0;

	class Test implements Runnable {
		// In sub-type of Runnable, it's easy to share resource
		@Override
		public void run() {
			for (int i=0; i<8; i++) 
				System.out.printf("%s : count is %d\n", Thread.currentThread().getName(), count++);
		}
	}
	
	public static void main(String args[]) {
		RunnableTest r = new RunnableTest();
		new Thread(r.new Test()).start();
		new Thread(r.new Test()).start();
	}
}
