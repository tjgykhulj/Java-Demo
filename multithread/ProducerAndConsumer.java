package demo.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerAndConsumer 
{
	class Meal {
		private final int orderNum;
		public Meal(int orderNum) { this.orderNum = orderNum; }
		public String toString() { return "Meal " + orderNum; }
	}

	class Waiter implements Runnable {
		private ProducerAndConsumer x;
		public Waiter(ProducerAndConsumer x) { this.x = x; }
		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					synchronized(this) {
						while (x.meal == null) wait();
					}
					System.out.println("Waiter got " + meal);
					synchronized(x.chef) {
						x.meal = null;
						x.chef.notifyAll();
					}
				}
			} catch (InterruptedException e) {
				System.out.println("Waiter interrupted");
			}
		}
	}
	
	class Chef implements Runnable {
		private ProducerAndConsumer x;
		private int count = 0;
		public Chef(ProducerAndConsumer x) { this.x = x; }
		
		public void run() {
			try {
				while (!Thread.interrupted()) {
					synchronized(this) {
						while (x.meal != null) wait();
					}
					if (++count == 10) {
						System.out.println("Out of food, closing!");
						x.exec.shutdownNow();
					}
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Order up");
					synchronized(x.waiter) {
						x.meal = new Meal(count);
						x.waiter.notifyAll();
					}
				}
			} catch (InterruptedException e) {
				System.out.println("Chef interrupted");
			}
		}
	}

	private Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	Waiter	waiter	= new Waiter(this);
	Chef	chef	= new Chef(this);
	
	public ProducerAndConsumer() {
		exec.execute(chef);
		exec.execute(waiter);
	}
	public static void main(String[] args) {
		new ProducerAndConsumer();
	}

}
