package demo.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ExecutorTest {
	@Test public void test1() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i=0; i<5; i++) exec.execute(new ThreadTest.Test());
		exec.shutdown();
	}
	
	@Test public void test2() {
		// 提示建立好线程池，以便提高效率
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i=0; i<5; i++) exec.execute(new ThreadTest.Test());
		exec.shutdown();
	}
	
	@Test public void test3() {
		// 提示建立好线程池，以便提高效率
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i=0; i<5; i++) exec.execute(new ThreadTest.Test());
		exec.shutdown();
	}
}
