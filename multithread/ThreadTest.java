package demo.multithread;

public class ThreadTest extends Thread {
	
	int number;
	static int count;
	
	/* In sub-type of Thread, it's hard to make a shared "testCount",
	 * because there's one instance each thread.
	 */
	int testCount;
	
	ThreadTest() {
		number = count++;
	}
	
	@Override
	public void run() {
		for (int i=0; i<8; i++) 
			System.out.printf("Thread %d : %d, total : %d\n", number, i, testCount++);
	}
	
	public static void main(String args[]) {
		ThreadTest a[] = { new ThreadTest(), new ThreadTest() };
		a[0].start();
		a[1].start();
	}
}
