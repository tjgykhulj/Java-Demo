package demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest {
	public static void main(String args[]) throws Exception {
		// read from System.in:
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		// Turn System.out into a PrintWriter
		PrintWriter stdout = new PrintWriter(System.out, true);
		stdout.println("Hello world, try to input a sentence.");
		stdout.println("(You will find a '!' before your input.)");
		stdout.append('!');

		PrintWriter output = new PrintWriter(new File("test.txt"));
		output.println("[IOTest.java] Test to output here.");
		
		if ((s = stdin.readLine())!=null) {
			stdout.println(s);
			output.println(s);
		}
		output.close();
	}
}
