package demo.collections;

import java.util.*;

@SuppressWarnings("serial")
public class QueueTest extends PriorityQueue<QueueTest.Item > 
{
	
	public static class Item implements Comparable<Item> 
	{
		int first, second;
		String value;
		Item(int k1, int k2, String val) {
			first = k1;
			second = k2;
			value = val;
		}
		@Override
		public int compareTo(Item o) {
			if (first < o.first || first == o.first && second < o.second) return -1;
			return (first== o.first && second == o.second)?0:1;
		}
	
		public String toString() {
			return String.format("[%d, %d : %s]", first, second, value);
		}
	}
	
	public void add(int k1, int k2, String value) {
		super.add(new Item(k1,k2,value));
	}
	
	static public void main(String args[]) {
		QueueTest test = new QueueTest();
		test.add(1,2,"a");
		test.add(1,3,"b");
		test.add(2,3,"c");
		while (!test.isEmpty()) System.out.println(test.remove());
	}
}
