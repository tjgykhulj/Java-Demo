package demo.multithread;

import org.junit.Test;

public class SynchronizedTest 
{
	static class MyThread extends Thread
	{
		// 类中带有synchronized的方法将只能同时被一个线程运行。
		private static int count = 0;
		synchronized private static int increase() {
			count++;
			yield();
			count++;
			return count;
		}	
		
		/*
		 * 临界区，此项与上面一项是一起的
		 */
		private int criticalSection() {
			synchronized (this) {
				count++;
				yield();
				count++;
				return count;
			}
		}

		@Override
		public void run() 
		{
			// nothing print
			for (int i=0; i<10000; i++) {
				if (increase() % 2 == 1) System.out.println("wrong");
			}
			// print wrong, 因为同步的是this，而这两个对象不是同一个
			for (int i=0; i<10000; i++)
				if (criticalSection() % 2 == 1) System.out.println("wrong");
		}
	}
	
	public static void main(String args[]) {
		new MyThread().start();
		new MyThread().start();
	}
	
}
