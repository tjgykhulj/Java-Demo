package demo.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class IOTest3 {

	public static void main(String[] args) throws Exception {
		/*
		 * BufferedReader(Reader) 包装一个Reader，拥有更好的输入，以及增加缓存提高IO效率
		 * FileReader(String filename) 是一个输入流的Reader派生类
		 */
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream("test.gz")));
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();

		@SuppressWarnings("resource")
		InputStreamReader gin = new InputStreamReader(new GZIPInputStream(
				new FileInputStream("test.gz")));

		while ((c = gin.read()) != -1)
			System.out.print((char) c);
	}
}
