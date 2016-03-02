package demo.generics;

import java.util.*;

interface Generator<T> { T next(); }

class FibonacciGen implements Generator<Integer> 
{
	private Integer a=1, b=1;
	
	public Integer next() {
		Integer result = a;
		a = b;
		b = result + a;
		return result;
	}
}

public class OtherTest extends demo.BaseDemo {

	public static <T> Collection<T>
	//there's no need to now the exactly type, complete abstraction
	fill(Collection<T> coll, Generator<T> gen, int size) 
	{
		for (int i=0; i<size; i++) coll.add(gen.next());
		return coll;
	}
	public static void main(String[] args) 
	{
		Collection<Integer> test = 
				fill(New.list(), new FibonacciGen(), 10);
		printArray(test);
	}

}
