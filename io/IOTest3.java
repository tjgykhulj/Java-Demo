package demo.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.zip.GZIPOutputStream;

public class IOTest3 {

	public static void main(String[] args) throws Exception {
		/*
		 * BufferedReader(Reader)
		 * 	��װһ��Reader��ӵ�и��õ����룬�Լ����ӻ������IOЧ��
		 * FileReader(String filename)
		 * 	��һ����������Reader������
		 */
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(
						new FileOutputStream("test.gz")));
		int c;
		while ((c = in.read())!=-1) out.write(c);
	}

}
