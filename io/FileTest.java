package demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

public class FileTest {

	// ʵ��FilenameFilter��ֻ��Ҫʵ��accept����
	static class DirFilter implements FilenameFilter {
		private Pattern pattern;
		public DirFilter(String regex) {
			pattern = Pattern.compile(regex);
		}
		@Override
		public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
		}
	}
	
	public static void main(String args[]) {
		// File(xx)��ȡxx�ļ����������ļ���
		File path = new File(".");
		// ���ˣ���������ֻ����Сд��ĸ���ļ�
		String[] list = path.list(new DirFilter("[a-z]*"));
		// ��Сд�������������
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(list));
	}
}
