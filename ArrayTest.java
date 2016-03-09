package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest extends BaseDemo {
	
	public static void main(String ar[]) {
		int a[][] = new int[3][];
		a[0] = new int[2];
		a[0][0] = a[0][1] = -1;
		a[1] = new int[3];
		println(Arrays.deepToString(a));
		
		// List<Integer>[] ls = new List<Integer>[10]; is leggal 
		List<Integer>[] ls = (List<Integer>[]) new List[10];
		ls[0] = new ArrayList<Integer>();
		Object[] os = ls;
		os[1] = new ArrayList<String>();
		((ArrayList<String>)os[0]).add("tjg");
		((ArrayList<Integer>)os[0]).add(123);
		println(ls[0]);
	}
}
