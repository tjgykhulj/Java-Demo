package demo.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.junit.Test;

public class CallableTest 
{
	Semaphore a;
	static class MyCallable implements Callable<String> 
	{
		static int count;
		int id;

		MyCallable() {
			id = count++;
		}
		@Override
		public String call() throws Exception {
			System.out.printf("MyCallable %d\n", id);
			TimeUnit.MILLISECONDS.sleep(id*1000);
			return "finish " + id;
		}

	}
	@Test public void test1() throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<>();
		for (int i=0; i<10; i++) list.add(exec.submit(new MyCallable()));
		
		for (Future<String> fs : list) System.out.println(fs.get());
		exec.shutdown();
	}
}
