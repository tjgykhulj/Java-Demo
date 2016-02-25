package demo;

import java.util.*;

public class QueueTest extends BaseDemo {
	static public void main(String args[]) {
		Queue<Character> queue = new LinkedList<Character>();
		// offer(x) insert x at the tail of the queue.
		for (char c : "MyNameIsTJG".toCharArray()) queue.offer(c);
		println(queue);
		/* Both peek() and element() return the head of the queue without removing it, 
		 * but peek() returns null if queue is empty and element() throws Exception.
		 * 
		 * Both poll() and remove() remove and return the head of the queue,
		 * but pool() returns null if queue is empty and remove() throws Exception.
		 */
		// "real queue" is create by : Queue test = new ArrayBlockingQueue(13);
		
		while (queue.peek() != null) print(queue.remove());
		print("\n");
		
		// PriorityQueue : poll will get the smallest/biggest element
		List<Integer> arr = Arrays.asList(1,9,9,5,0,4,0,1);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr);
		while (!pq.isEmpty()) print(pq.poll());
		print("\n");

		pq = new PriorityQueue<Integer>(arr.size(), Collections.reverseOrder());
		for (Integer x : arr) pq.offer(x);
		while (!pq.isEmpty()) print(pq.poll());
		print("\n");
	}
}
