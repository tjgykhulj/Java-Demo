package demo.multithread;

import static demo.BaseDemo.*;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import demo.multithread.Toast.Status;

/*
 * 模拟吐司制作、上黄油、上果酱的流程，共有三个状态
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

// 随机睡眠一段时间的Runnable类型
// 运行内容是从先取得一片吐司，睡一段时间模拟在处理工序，之后实际处理这片吐司
abstract class RandomSleep implements Runnable {
	private Random random = new Random();
	protected void randomSleep() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(500+random.nextInt(1000));	
	}
	// 此处的处理格式是模板，可复用
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

// 预处理是新建Toast，后处理是将其装入output
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

// 上黄油，Toaster的output即Butterer的input，从那里读入后睡一段时间后装入output
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

// 上果酱，同上
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
// 吃，只取不创建
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
 * 放一个Executor里统一执行，结尾处睡五秒并结束，来模拟处理一段时间
 * 结尾处shutdownNow()可使四个处理器输出被打断并结束
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
