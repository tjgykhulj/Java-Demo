package demo.multithread;

import static demo.BaseDemo.*;

public class ThreadTest 
{
	// Thread��Runnable��ʵ���ܹ�����Դ
	// �������������һ��Thread����x���ٴ�����Thread�½���û����
	static class Test implements Runnable
	{
		static int count;
		
		int id;
		Test() {
			id = count++;
			printf("Create %d\n", id);
		}
		@Override
		public void run() {
			printf("Run %d\n", id);
			// ���̵߳������Ľ��飬���������л�������������
			Thread.yield();
			Thread.yield();
			Thread.yield();
			printf("Close %d\n", id);
		}
	}
	
	public static void main(String args[]) {
		for (int i=0; i<10; i++) new Thread(new Test()).start();
	}
}
