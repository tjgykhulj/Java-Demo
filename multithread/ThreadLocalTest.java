package demo.multithread;

public class ThreadLocalTest {

	static class MyRunnable implements Runnable {
		@Override
		public void run() {
			for (int i=0; i<5; i++) {
				System.out.printf("id=%d i=%d value=%d\n", Thread.currentThread().getId(), i, value.get());
				increase();
			}
		}
		
	}
	
	// ������־�������Ϊ��ÿ���̶߳��Զ���һ������
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		protected synchronized Integer initialValue() {
			return 0;
		}
	};
	private static void increase() {
		value.set(value.get() + 1);
	}
	
	public static void main(String args[]) {
		Runnable x = new MyRunnable();
		for (int i=0; i<3; i++) new Thread(x).start();
	}

}
