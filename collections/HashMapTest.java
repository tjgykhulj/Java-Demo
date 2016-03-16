package demo.collections;

import java.util.*;

import demo.BaseDemo;

public class HashMapTest extends BaseDemo {

	static class Key {
		int a;
		Key(int aa) { a = aa; }

		@Override
		public int hashCode() {
			return a;
		}
		@Override
		public boolean equals(Object o) {
			return o instanceof Key && ((Key) o).a == a;
		}
	}
	
	static public void main(String arg[]) {
		Map<Key, String> maps = new HashMap<>();
		maps.put(new Key(1), "tjg");
		println(maps.get(new Key(1)));
	}
}
