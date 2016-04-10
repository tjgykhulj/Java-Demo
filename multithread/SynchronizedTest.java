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
		
		/*
		 * �ٽ���������������һ����һ���
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
			// print wrong, ��Ϊͬ������this����������������ͬһ��
			for (int i=0; i<10000; i++)
				if (criticalSection() % 2 == 1) System.out.println("wrong");
		}
	}
	
	public static void main(String args[]) {
		new MyThread().start();
		new MyThread().start();
	}
	
}
