package demo.io;

import java.io.File;
import java.io.IOException;

public class FileTest3 
{
	static void fileData(File f) {
		System.out.println(
				"Absolute path: " + f.getAbsolutePath() +
				"\n Can read: " + f.canRead() +
				"\n Can write: " + f.canWrite() +
				"\n getName: " + f.getName() +
				"\n getParent: " + f.getParent() +
				"\n getPath: " + f.getPath() +
				"\n length: " + f.length() +
				"\n lastModified: " + f.lastModified());
		System.out.println("It's a " + (f.isFile()?"file":"director"));
	}
	
	public static void main(String args[]) {
		File file = new File("try.txt");
		try {
			if (!file.exists())	file.createNewFile();
			/* 
			 * file.delete();
			 * file.mkdir();
			 * file.renameTo((File)new_dir);
			 */
		} catch (IOException e) {
			System.out.println("create new-file fail");
			e.printStackTrace();
		}
		fileData(file);
	}
}
