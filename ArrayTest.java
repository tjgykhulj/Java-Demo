package demo;

import java.util.*;

public class ArrayTest extends BaseDemo {
	
	public static void main(String ar[]) {
		//多维数组
		int a[][] = new int[3][];
		a[0] = new int[2];
		a[0][0] = a[0][1] = -1;
		a[1] = new int[3];
		println(Arrays.deepToString(a));
		
		//类型转换，容器泛型的边界在存取时的类型检查，转为Object后就失去了原有检查信息，成为一个无参容器
		// List<Integer>[] ls = new List<Integer>[10]; is leggal 
		List<Integer>[] ls = (List<Integer>[]) new List[10];
		ls[0] = new ArrayList<Integer>();
		Object[] os = ls;
		os[1] = new ArrayList<String>();
		((ArrayList<String>)os[0]).add("tjg");
		((ArrayList<Integer>)os[0]).add(123);
		println(ls[0]);
		
		// fill / arraycopy
		int b[] = new int[7];
		Arrays.fill(b, 1);
		int c[] = new int[10];
		System.arraycopy(b, 0, c, 1, b.length);
		println(Arrays.toString(c));
	}
}
