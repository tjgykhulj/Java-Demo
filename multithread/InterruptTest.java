package demo.multithread;

import static demo.BaseDemo.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class InterruptTest {

	static class MRun implements Runnable 
	{
		Lock lock = new ReentrantLock();
		
		synchronized private void f() {
			lock.lock();
			try {
				while (true) Thread.yield();
			} finally {
				lock.unlock();
			}
		}
		
		int mode;
		MRun(int mode) {
			this.mode = mode;
			// it will hold the lock and never release
			new Thread() {
				public void run() {f();}
			}.start();
		}
		
		@Override
		public void run() {
			printf("[Mode %d] Thread start\n", mode);
			try {
				switch (mode) {
				/* 
				 * sleep/lockInterruptibly可被打断，IO/Synchronized阻塞不可打断
				 * 打断堵塞可通过外界的Future.cancel(true)
				 * PS: NIO中有可打断的文件、网络通道
				 */
					case 0: TimeUnit.SECONDS.sleep(10); break;
					case 1: println("input something"); System.in.read(); break;
					case 2: lock.lockInterruptibly(); break;
					case 3: synchronized (this) {
						println("It won't be printed!!!");
					}
				}
			} catch (Exception e) {
				printf("[Mode %d] Interrupted\n", mode);	
			}
			printf("[Mode %d] Thread end\n", mode);
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<4; i++) {
			Future<?> a = exec.submit(new MRun(i));
			TimeUnit.MILLISECONDS.sleep(500);
			a.cancel(true);
		}
		println("wait for 5s and close");
		TimeUnit.SECONDS.sleep(5);
		System.exit(0);
	}
}
