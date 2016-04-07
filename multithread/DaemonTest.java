package demo.multithread;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import static demo.BaseDemo.*;

public class DaemonTest {

	static class B implements Runnable {
		static int count;
		@Override
		public void run() {
			int id = count++;
			try {
				printf("B[%d] go to sleep\n", id);
				TimeUnit.MICROSECONDS.sleep(500);
				printf("B[%d] awake \n", id);
				// they will stop if main() is over
				while (true) Thread.yield();
			} catch (InterruptedException e) {
				printf("B[%d] interrupt\n", id);
			} finally {
				println("can't be print if it have been interrupted");
			}
		}
	}
	
	static class A implements Runnable 
	{
		@Override
		public void run() {
			println("A");
			for (int i=0; i<10; i++) new Thread(new B()).start();
		}
		
	}
	
	@Test public void test1() throws InterruptedException {
		Thread t = new Thread(new A());
		t.setDaemon(true);
		t.start();
		TimeUnit.MILLISECONDS.sleep(1000);
		println("finish");
	}
}