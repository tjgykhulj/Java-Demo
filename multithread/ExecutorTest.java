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
		// ��ʾ�������̳߳أ��Ա����Ч��
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i=0; i<5; i++) exec.execute(new ThreadTest.Test());
		exec.shutdown();
	}
	
	@Test public void test3() {
		// ��ʾ�������̳߳أ��Ա����Ч��
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i=0; i<5; i++) exec.execute(new ThreadTest.Test());
		exec.shutdown();
	}
}
