package demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortDemo extends BaseDemo {
	
	static final Random random = new Random();

	// 写类时实现Comparable接口，并重写compareTo函数，可自动用于排序
	static class A implements Comparable<A> {
		int a,b;
		A() {
			this.a = random.nextInt(100);
			this.b = random.nextInt(100);
		}
		public String toString() {
			return String.format("[%d,%d]", a,b);
		}
		@Override
		public int compareTo(A o) {
			return (a<o.a || a==o.a && b<o.b)?-1:1;
		}
	}

	// 或另写一个比较器Comparator代入
	static class MyComparator implements Comparator<A> {
		@Override
		public int compare(A o1, A o2) {
			return (o1.b<o2.b)?-1:1; 
		}
		
	}
	
	public static void main(String ars[]) {
		A[] arr = new A[10];
		for (int i=0; i<arr.length; i++) arr[i] = new A();

		// Comparator
		//Arrays.sort(arr, new MyComparator());
		//println(Arrays.toString(arr));
		// Comparable
		Arrays.sort(arr);
		println(Arrays.toString(arr));
		// Binary search an item in an sorted-array
		A test = new A();
		int pos = Arrays.binarySearch(arr, test);
		// < 0 即是没有找到相同的元素，但将返回最接近的小于它的元素位置的-pos-1
		if (pos < 0) pos = -pos-1;
		
		try {
			printf("%s <= arr[%d] == %s\n", test, pos, arr[pos]);
		} catch (Exception e) {
			printf("%s is the largest\n", test);
		}
	}
}
