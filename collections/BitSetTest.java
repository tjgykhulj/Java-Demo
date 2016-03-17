package demo.collections;

import java.util.BitSet;

import demo.BaseDemo;

public class BitSetTest extends BaseDemo {
	static public void main(String arg[]) {
		BitSet bs = new BitSet(1000);
		// isEmpty
		println(bs.isEmpty());
		// size : 1024 // it must be 2^x
		println(bs.size());

		// set : bs[pos]=true
		bs.set(99);
		bs.set(100);
		// clear : bs[pos]=false
		bs.clear(100);
		println(bs);
		
		BitSet bs2 = new BitSet(1000);
		bs2.set(30);
		// or\and\xor\andNot\get
		bs.or(bs2);
		println(bs);
	}
}
