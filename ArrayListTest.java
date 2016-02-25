package demo;

import java.util.*;

public class ArrayListTest extends BaseDemo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static public void main(String a[]) 
	{
		List collection = new ArrayList(Arrays.asList(1,2,"JG", 3));
		// add new items
		collection.add(3,"Tang");
		//print collection[xx] and indexOf(xx)
		String s = (String) collection.get(2);
		println(s + " : " + collection.indexOf(s));
		// remove items
		collection.remove(0);
		
		Collections.addAll(collection, 4, 5, 6);
		println(collection);
		
		// other methods
		List sub = collection.subList(1, 3);
		collection.removeAll(sub);
		println(collection);
		
		/*
		 * Iterator can work with different types of collection
		 * 因为无关容器，所以方便复用代码 ( next and remove )
		 */
		Iterator it = collection.iterator();
		while (it.hasNext()) print(it.next() + " ");
		println(" [iterator end]");
		// Then try to remove, test whether collection change
		it = collection.iterator();
		for (int i=0; i<2; i++) {
			it.next(); it.remove();
		}
		println(collection);
	}
}