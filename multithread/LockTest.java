package demo.multithread;

import java.util.concurrent.locks.*;

import org.junit.Test;

public class LockTest extends Thread
{
	// 普通意义上的锁
	private static Lock lock = new ReentrantLock();

	private static int count = 0;
	private static int increase() {
		lock.lock();
		try {
			count++;
			Thread.yield();
			count++;
			return count;
		} finally {
			lock.unlock();
		}
	}	

	@Override	
	public void run() 
	{
		for (int i=0; i<10000; i++) {
			int ret = increase();	// 
			if (ret%2 == 1) System.out.println("wrong");
		}
	}

	@Test
	public void test() {
		new LockTest().start();
		new LockTest().start();
		new LockTest().start();
	}
}
