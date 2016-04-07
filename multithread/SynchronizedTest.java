package demo.multithread;

import org.junit.Test;

public class SynchronizedTest 
{
	static class MyThread extends Thread
	{
		// ���д���synchronized�ķ�����ֻ��ͬʱ��һ���߳����С�
		private static int count = 0;
		synchronized private static int increase() {
			count++;
			yield();
			count++;
			return count;
		}	

		@Override
		public void run() 
		{
			for (int i=0; i<10000; i++) {
				int ret = increase();	// 
				if (ret%2 == 1) System.out.println("wrong");
			}
		}
	}
	
	@Test
	public void test() {
		new MyThread().start();
		new MyThread().start();
	}
	
}
