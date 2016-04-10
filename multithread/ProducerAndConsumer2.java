package demo.multithread;

import static demo.BaseDemo.*;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import demo.multithread.Toast.Status;

/*
 * ģ����˾�������ϻ��͡��Ϲ��������̣���������״̬
 */
class Toast {
	public enum Status { DRY, BUTTERED, JAMMED }
	public Status status = Status.DRY;
	
	private static int gid = 0;
	public final int id;
	Toast() { this.id = gid++; }
	
	public void butter() { status = Status.BUTTERED; }
	public void jam() 	{ status = Status.JAMMED; } 
	public String toString() {
		return String.format("Toast %d : %s", id, status);
	}
}

@SuppressWarnings("serial")
class ToastQueue extends LinkedBlockingQueue<Toast> {}

// ���˯��һ��ʱ���Runnable����
// ���������Ǵ���ȡ��һƬ��˾��˯һ��ʱ��ģ���ڴ�����֮��ʵ�ʴ�����Ƭ��˾
abstract class RandomSleep implements Runnable {
	private Random random = new Random();
	protected void randomSleep() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(500+random.nextInt(1000));	
	}
	// �˴��Ĵ����ʽ��ģ�壬�ɸ���
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = get();
				randomSleep();
				deal(t);
			}
		} catch (InterruptedException e) {
			println(this.getClass().getSimpleName() + " interrupted");
		}
		println(this.getClass().getSimpleName() + " off");
	}
	abstract protected Toast get() throws InterruptedException;
	abstract protected void deal(Toast t);
}

// Ԥ�������½�Toast�������ǽ���װ��output
class Toaster extends RandomSleep
{
	ToastQueue output;
	Toaster(ToastQueue output) {
		this.output = output; 
	}
	
	protected Toast get() { return new Toast();	}
	protected void deal(Toast t) {
		println(t);
		output.add(t);
	}
}

// �ϻ��ͣ�Toaster��output��Butterer��input������������˯һ��ʱ���װ��output
class Butterer extends RandomSleep
{
	ToastQueue input, output;
	Butterer(ToastQueue input, ToastQueue output) { 
		this.input = input; 
		this.output = output; 
	}
	protected Toast get() throws InterruptedException { return input.take(); }
	protected void deal(Toast t) {
		t.butter();
		println(t);
		output.add(t);
	}
}

// �Ϲ�����ͬ��
class Jammer extends RandomSleep
{
	ToastQueue input, output;
	Jammer(ToastQueue input, ToastQueue output) { 
		this.input = input; 
		this.output = output; 
	}
	protected Toast get() throws InterruptedException { return input.take(); }
	protected void deal(Toast t) {
		t.jam();
		println(t);
		output.add(t);
	}
}
// �ԣ�ֻȡ������
class Eater extends RandomSleep
{
	ToastQueue input;
	Eater(ToastQueue input) {
		this.input = input; 
	}
	protected Toast get() throws InterruptedException { return input.take(); }
	protected void deal(Toast t) {
		println("Chomp! " + t);
	}
}

/*
 * ��һ��Executor��ͳһִ�У���β��˯���벢��������ģ�⴦��һ��ʱ��
 * ��β��shutdownNow()��ʹ�ĸ��������������ϲ�����
 */
public class ProducerAndConsumer2 {
	public static void main(String[] args) throws Exception {
		ToastQueue dryQueue = new ToastQueue(),
				butteredQueue = new ToastQueue(),
				finishedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
