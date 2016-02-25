package demo;

import java.util.Iterator;

public class IterableDemo extends BaseDemo implements Iterable<Object> {

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() 
		{
			private int index = 0;
			public boolean hasNext() { return index < pos; }
			public Object next() { return a[index++]; }
		};
	}
	private int size = 10, pos = 0;
	private Object a[] = new Object[size];
	
	// 超过容量则将容量翻倍
	public void push(Object x) {
		a[pos++] = x;
		if (pos < size) return;
		
		Object temp[] = new Object[size<<=1];
		for (int i=0; i<pos; i++) temp[i] = a[i];
		a = temp;
	}
	
	public Object get(int index) throws Exception {
		if (index >= pos) throw new Exception("Out of range");
		return a[index];
	}
	
	static public void main(String a[]) {
		try {
			IterableDemo x = new IterableDemo();
			for (int i=0; i<25; i++) x.push(i);
			println("pos : " + x.pos);
			println("size: " + x.size);
			println(x.get(13));
			// It can use "for each" if implement Iterator
			for (Object i : x) print(i+" ");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
