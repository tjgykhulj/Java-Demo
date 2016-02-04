package demo;
import java.util.Random;
//: test01/main.java

class Test {
	static int x = 3;
}

public class RandomTest extends BaseDemo {
	/** try java.util.Random */
	
	public static void main(String[] args) {
		Random rand = new Random();
		print(rand.nextInt(100));
		print(rand.nextInt(100));
		print(rand.nextFloat());
	}
} ///:~
