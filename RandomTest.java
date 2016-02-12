package demo;
import java.util.Random;
//: test01/main.java


public class RandomTest extends BaseDemo {
	/** try java.util.Random */
	public static void main(String args[]) {
		Random rand = new Random();
		println(rand.nextInt(100));
		println(rand.nextBoolean());
		println(rand.nextDouble());
		println(rand.nextFloat());
	}
} ///:~
