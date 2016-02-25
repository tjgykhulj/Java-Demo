package demo;

import java.util.*;

public class MapDemo<T> extends BaseDemo {
	Map<T, Integer> content = new HashMap<T, Integer>();
	
	void insert(T t) {
		Integer val = content.get(t);
		content.put(t, val==null? 1 : val+1);
	}
	int count(T t) {
		Integer val = content.get(t);
		return val==null? 0 : val;
	}
	boolean containKey(T t) {
		return content.containsKey(t);
		// content.containsValue(x);
	}
	int delete(T t) {
		Integer val = content.get(t);
		if (val == null) return -1;
		if (val == 1)
			content.remove(t);
		else 
			content.put(t,  val - 1);
		return val - 1;
	}
	public String toString() {
		return String.format("[key] : %s\n[val] : %s", content.keySet(), content.values());
	}
	
	static public void main(String args[]) {
		MapDemo<String> test = new MapDemo<String>();
		test.insert("tjg");
		test.insert("dd");
		test.insert("zy");
		test.insert("tjg");
		println(test);
		test.delete("tjg");
		test.delete("dd");
		println(test);
		println(test.containKey("tjg"));
		println(test.containKey("dd"));
	}
}
