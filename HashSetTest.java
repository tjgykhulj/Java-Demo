package demo;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class HashSetTest extends BaseDemo {
	
	static Set intersection(Set a, Set b) {
		Set res = new HashSet(a);
		res.retainAll(b);
		return res;
	}
	static Set union(Set a, Set b) {
		Set res = new HashSet(a);
		res.addAll(b);
		return res;
	}
	static Set subtraction(Set a, Set b) {
		Set res = new HashSet(a);
		res.removeAll(b);
		return res;
	}
	
	public static void main(String args[]) {
		Set<String> s1 = new HashSet<String>();
		Collections.addAll(s1, "a b c d e".split(" "));
		Set<String> s2 = new HashSet<String>();
		Collections.addAll(s2, "d e f g".split(" "));
		println("s1 : " + s1);
		println("s2 : " + s2);
		println("s1 and s2 : " + intersection(s1,s2));
		println("s1 or s2 : " + union(s1,s2));
		println("s1 - s2 : " + subtraction(s1,s2));
	}
	
}
