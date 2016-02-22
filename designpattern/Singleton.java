package demo.designpattern;

public class Singleton {
	// 由于是内部static类，在未访问前不会创建INSTANCE，可节省资源
	private static class SingletonHolder {  
		private static final Singleton INSTANCE = new Singleton();  
	}  
	private Singleton (){}
	public static final Singleton getInstance() {
		//直接返回值，不会有多线程问题
		return SingletonHolder.INSTANCE;  
	}  
}  
