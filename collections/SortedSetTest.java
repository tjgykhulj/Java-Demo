package demo.collections;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import demo.BaseDemo;

public class SortedSetTest extends BaseDemo {

	private static Random random = new Random();
	
	static class Test implements Comparable<Test> {
		int a,b;
		Test(int x) {
			a = random.nextInt(x);
			b = random.nextInt(x);
		}
		
		public String toString() { return String.format("[%s,%s]", a, b); }
		// 实现此函数可控制重复key
		@Override
		public int compareTo(Test o) {
			if (a+b == o.a+o.b) return 0;
			return (a+b < o.a+o.b) ? -1 : 1;	
		}
	}
	
	/* or implements a Comparator<T>
	 * and new TreeSet<Test>(new TestComparator())
	 * 
	static class TestComparator implements Comparator<Test>
	{
		@Override
		public int compare(Test t1, Test t2) {
			return (t1.a + t1.b < t2.a + t2.b) ? 1 : -1;
		}
	}
	*/
	
	public static void main(String[] args) {
		SortedSet<Test> set = new TreeSet<Test>();
		for (int i=0; i<10; i++) set.add(new Test(100));
		println(set.toString());
		printf("First : %s,  Tail : %s\n", set.first(), set.last());
		Test sample = new Test(100);
		printf("Random Sample Item : %s\n", sample);
		printf("All item more then sample : %s\n", set.headSet(sample));
		printf("All item not more then sample : %s\n", set.tailSet(sample));
		// set.subSet(low, high)
	}
}
