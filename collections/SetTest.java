package demo.collections;

import java.util.*;

import demo.BaseDemo;

interface Generator<T> { T next(); }

public class SetTest extends BaseDemo {
	
	static class MyGenerator implements Generator<Integer> {
		static Integer count = 0;
		public Integer next() { return count++; }
	}
	static class CollectionData<T> extends ArrayList<T> {
		private static final long serialVersionUID = 7774661502085603813L;

		CollectionData(Generator<T> gen, int size) {
			while (size-- > 0) add(gen.next());
		}
	}
	
	static class SetType {
		int i;
		SetType(int n) { i = n; }
		@Override
		public boolean equals(Object o) {
			return o instanceof SetType && (i == ((SetType)o).i);
		}
		
		@Override
		public int hashCode() { return i; }
		@Override
		public String toString() {
			return String.valueOf(i);
		}
	}
	
	public static void main(String[] args) 
	{
		List<Integer> test = new CollectionData<Integer>(new MyGenerator(), 10);
		println(test);
		
		Set<SetType> sets = new HashSet<SetType>();
		SetType item1 = new SetType(10);
		SetType item2 = new SetType(10);
		sets.add(item1);
		sets.add(item2);
		// 只存入一个10
		println(sets);
	}
}
