package demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

public class FileTest {

	// 实现FilenameFilter，只需要实现accept函数
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
		// File(xx)获取xx文件夹下所有文件名
		File path = new File(".");
		// 过滤：保留所有只包含小写字母的文件
		String[] list = path.list(new DirFilter("[a-z]*"));
		// 大小写不敏感排序并输出
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(list));
	}
}
