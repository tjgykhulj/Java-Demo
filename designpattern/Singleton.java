package demo.designpattern;

public class Singleton {
	// �������ڲ�static�࣬��δ����ǰ���ᴴ��INSTANCE���ɽ�ʡ��Դ
	private static class SingletonHolder {  
		private static final Singleton INSTANCE = new Singleton();  
	}  
	private Singleton (){}
	public static final Singleton getInstance() {
		//ֱ�ӷ���ֵ�������ж��߳�����
		return SingletonHolder.INSTANCE;  
	}  
}  
