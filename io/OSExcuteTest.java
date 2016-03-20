package demo.io;

import java.io.*;

public class OSExcuteTest {
			
	public static void excute(String command) {
		try {
			if (!command.startsWith("CMD /C")) {
				command = "CMD /C " + command;
			}
			Process proc = new ProcessBuilder(command.split(" ")).start();
			BufferedReader result = new BufferedReader(
					new InputStreamReader(proc.getInputStream()));
			String s;
			while ((s = result.readLine())!=null) 
				System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		excute("dir");
	}

}
