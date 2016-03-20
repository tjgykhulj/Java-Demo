package demo.io;

import java.io.File;
import java.util.*;

public class FileTest2 {

	static class TreeInfo
	{
		public List<File> dirs = new ArrayList<>();
		public List<File> files = new ArrayList<>();
		public void add(TreeInfo o) {
			dirs.addAll(o.dirs);
			files.addAll(o.files);
		}
		@Override
		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("dirs :\n");
			for (File i : dirs) buf.append(i.toString()+"\n");
			buf.append("files :\n");
			for (File i : files) buf.append(i.toString()+"\n");
			return buf.toString();
		}
	}
	
	static TreeInfo recurseDirs(File dirs, String reg) {
		TreeInfo result = new TreeInfo();
		for (File item : dirs.listFiles())
		{
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.add(recurseDirs(item, reg));
			} else
				if (item.getName().matches(reg))
					result.files.add(item);
		}
		return result;
	}
	static public TreeInfo walk(String dir) {
		return recurseDirs(new File(dir), ".*\\.java");
	}
	
	public static void main(String args[]) {
		System.out.println(walk("."));
	}
}
