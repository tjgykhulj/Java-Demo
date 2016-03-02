package demo.multithread;

public class RunnableTest implements Runnable 
{
	int count;
	// In sub-type of Runnable, it's easy to share resource
	@Override
	public void run() {
		for (int i=0; i<8; i++) 
			System.out.printf("%s : count is %d\n", Thread.currentThread().getName(), count++);
	}
	
	public static void main(String args[]) {
		ThreadTest a = new ThreadTest();
		new Thread(a, "No.1").start();
		new Thread(a, "No.2").start();
	}
}
