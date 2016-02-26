package demo;

import java.util.logging.*;

public class ExceptionAndLoggingTest extends BaseDemo {

	static class LoggingDemo extends Exception {
		private static Logger logger = Logger.getLogger("LogginDemo");
		LoggingDemo(int x) {
			logger.severe("Test Logging : " + x);
		}
		public String toString() {
			return "LoggingDemo";
		}
	}	
	static class VeryImportantException extends Exception 
	{ 
		public String toString() {
			return "VeryImportantException";
		}
	}	

	private static void f() throws LoggingDemo {
		try {
			throw new LoggingDemo(47);
		} catch(LoggingDemo e) {
			for (StackTraceElement x : e.getStackTrace()) {
				println(x.getMethodName());
			}
			// You can throw it to outer environment;
			throw e;
		}
	}

	public static void main(String[] as) 
	{
		try {
			try {
				throw new VeryImportantException();
			} finally {
				// If throw exceptions or "return" in here,
				// normal exceptions or "return" will be covered.
				f();
			}
		} catch (Exception e) {
			/* it will ignore VeryImportException
			 * because finally throw a exception to cover it
			 */
			println(e);	
		}
	}
}
