package demo.multithread;

import static demo.BaseDemo.*;

public class ThreadTest 
{
	// Thread与Runnable其实都能共享资源
	// 但是如果创造了一个Thread对象x，再代入多个Thread新建很没意义
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
			// 对线程调度器的建议，声明可以切换给其它任务了
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
